import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed,async,inject } from '@angular/core/testing';
import { UsersService } from './users.service';

describe('UsersService', () => {
  let service: UsersService;
  let httpmock=HttpTestingController;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      providers:[UsersService]

    });
    service = TestBed.get(UsersService);
    httpmock=TestBed.get(HttpTestingController)
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it(`should fetch users  as an observable`,
    async(inject([HttpTestingController, UsersService],
 ( httpClient:HttpTestingController, 
  uservice:UsersService)=>{
     const   uitems=[
      {
      'userId':1,
	    'name':'testname',
      'email':'testmail@gmail.com',
	    'password':'Pass@123',
	    'cpassword':'Pass@123',
	    'contact':9988788890
      },
      {
        'userId':2,
	    'name':'testname2',
      'email':'testmail2@gmail.com',
	    'password':'Pass@1232',
	    'cpassword':'Pass@1232',
	    'contact':9988708890
      }
    ];
    uservice.getUsers().subscribe((e:any)=>{
      expect(e.length).toBe(2);
    });
    // let  req=httpmock.expectOne('http://localhost:3000/employee');
    // expect(req.request.method).toBe('GET');
    // req.flush(uitems);
    // httpmock.verify();
  })));
});
