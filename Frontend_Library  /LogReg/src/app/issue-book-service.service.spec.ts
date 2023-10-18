import { TestBed } from '@angular/core/testing';

import { IssueBookServiceService } from './issue-book-service.service';

describe('IssueBookServiceService', () => {
  let service: IssueBookServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IssueBookServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
