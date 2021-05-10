import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Tests } from 'src/app/class/tests';
import { TestsService } from "../../../services/tests.service";

@Component({
  selector: 'app-create-tests',
  templateUrl: './create-tests.component.html',
  styleUrls: ['./create-tests.component.css']
})
export class CreateTestsComponent implements OnInit {

  tests:Tests=new Tests(); 

  constructor(private router: Router,private testsService:TestsService) { }

  ngOnInit(): void {
  }

  saveTests()
  {
    this.testsService.createTests(this.tests).subscribe(data=>{
      console.log(data);
      alert("Test has added successfully");
      this.tests=new Tests();
      this.goToTestsList();
    },
    error=>console.log(error));
  }
  
  goToTestsList(){
    this.router.navigate(['/tests-list']);
  }

  onSubmit(){
    console.log(this.tests);
    this.saveTests();
  }
}


 
 
