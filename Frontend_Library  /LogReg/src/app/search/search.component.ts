import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { Book } from '../book.model';
import { BookserviceService } from '../bookservice.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {
  errormsg: any;
  
  constructor(private bookService: BookserviceService,private router:Router,private toast:NgToastService){
  }

  ngOnInit(): void{
    
  }

  book=new Book();
  bookId:number;
  show=false;


  interval:any;
  refresh() {
    this.interval = setTimeout(() => {
      location.reload()
    }, 100);
  }
  searchBook(){
    this.show=true;
    this.bookService.getBook(this.bookId).subscribe(
      data=>{
        this.book=data;
      },
      error=>{
        alert("Book cannot find");
      }
    )
  }

  deleteBook(){
    console.log(this.bookId);
    this.bookService.deletebook(this.bookId).subscribe(
      data=>{
        //alert("Book deleted");
       // this.router.navigate(['/booklist']);
      this.toast.success({detail:"Done!",summary:"Book Deleted Successfully", duration:3000});
        this.refresh();
      },
      error=>{
        console.log(error);
        alert("Book cannot find");
        // this.toast.error({detail:"Sorry",summary:"Book can't be deleted",duration:3000}))
      }
    )

  }
  
  updateBook(){
    this.book.bookPic=this.pic;
    this.bookService.updateBook(this.bookId,this.book).subscribe(
      data=>{
        //alert("Book is updated");
        //this.router.navigate(['/booklist']);
        this.toast.success({detail:"Success",summary:"Book Updated", duration:3000});
        this.refresh();
        console.log(data);
      },
      error=>{
        //alert("Book cannot find");
        this.toast.error({detail:"Error",summary:"Book Cannot find", duration:3000})
      }
    )
  }

  pic: any;
  onFileUpload(fileInput:any){
    let rdr=new FileReader();

    rdr.onload= (e:any)=>{
      let img=new Image();
      img.src=e.target.result;

      img.onload = rs=>{
        this.pic=e.target.result;
      }
    }
    rdr.readAsDataURL(fileInput.target.files[0]);
  }
  

  

}
