import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Tests } from 'src/app/class/tests';
import { TestsService } from 'src/app/services/tests.service';

@Component({
  selector: 'app-test-list-user',
  templateUrl: './test-list-user.component.html',
  styleUrls: ['./test-list-user.component.css']
})
export class TestListUserComponent implements OnInit {

  
  tests:Tests[];
  name:string;
  constructor(private testsService:TestsService,private router:Router) { }

  ngOnInit(): void 
  {
    this.getTests();
  }

  getTests()
  {
    this.testsService.getTestsList().subscribe(data=>this.tests=data);
  }

  testByName()
  {
    this.testsService.getTestsListByName(this.name).subscribe(data=>this.tests=data);
  }


}
