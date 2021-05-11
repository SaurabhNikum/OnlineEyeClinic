import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Tests } from 'src/app/class/tests';
import { TestsService } from "../../../services/tests.service";

@Component({
  selector: 'app-tests-details',
  templateUrl: './tests-details.component.html',
  styleUrls: ['./tests-details.component.css']
})
export class TestsDetailsComponent implements OnInit {

  id:number;
  tests:Tests;  

  constructor(private route: ActivatedRoute,private testsService:TestsService,private router:Router) { }

  ngOnInit(): void 
  {
    this.id = this.route.snapshot.params['id'];
    this.tests=new Tests();
    this.testsService.getTestsId(this.id).subscribe(data=>this.tests=data);
  }

  goToTestsList(){
    this.router.navigate(['/tests-list']);
  }

  updateTests(id:number)
  {
    this.router.navigate(['update-tests', id]);
  }

  deleteTests(id:number)
  {
    this.testsService.deleteTests(id).subscribe();
    alert("Test has deleted successfully");
    this.goToTestsList();
  }

}




  
  


