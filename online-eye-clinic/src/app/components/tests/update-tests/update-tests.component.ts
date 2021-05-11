import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Tests } from 'src/app/class/tests';
import { TestsService } from "../../../services/tests.service";


@Component({
  selector: 'app-update-tests',
  templateUrl: './update-tests.component.html',
  styleUrls: ['./update-tests.component.css']
})
export class UpdateTestsComponent implements OnInit {

  constructor(private route: ActivatedRoute,private router: Router,private testsService:TestsService) { }

  id: number;
  tests:Tests=new Tests();

  ngOnInit(): void 
  {
    this.id = this.route.snapshot.params['id'];
    this.testsService.getTestsId(this.id).subscribe(data=>
      {this.tests=data;},
      error=>console.log(error));
  }

  onSubmit()
  {
    this.testsService.updateTests(this.id,this.tests).subscribe();
    alert("Updated successfully");
    this.goToTestDetails();
  }

  goToTestDetails()
  {
    this.router.navigate(['/tests-details',this.id]);
  }

  goBack()
  {
    this.router.navigate(['tests-list']);
  }


}

