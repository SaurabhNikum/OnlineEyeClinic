import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Tests } from 'src/app/class/tests';
import { TestsService } from "../../../services/tests.service";


@Component({
  selector: 'app-tests-list',
  templateUrl: './tests-list.component.html',
  styleUrls: ['./tests-list.component.css']
})
export class TestsListComponent implements OnInit {

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

  testsDetails(id:number)
  {
    this.router.navigate(['tests-details', id]);
  }

  testByName()
  {
    this.testsService.getTestsListByName(this.name).subscribe(data=>this.tests=data);
  }

  updateTests(id:number)
  {
    this.router.navigate(['update-tests', id]);
  }

  deleteTests(id:number)
  {
    this.testsService.deleteTests(id).subscribe(
      data=>{alert("Test has deleted successfully");
      this.getTests();
    },
      error=>{
        console.log(error);
        alert("Deletion failed");}
    );
    this.getTests();
  }
}
