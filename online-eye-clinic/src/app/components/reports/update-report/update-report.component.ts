import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Report } from 'src/app/class/report';
import { ReportService } from 'src/app/services/report.service';

@Component({
  selector: 'app-update-report',
  templateUrl: './update-report.component.html',
  styleUrls: ['./update-report.component.css']
})
export class UpdateReportComponent implements OnInit {

  constructor(private route: ActivatedRoute,private router: Router,private reportService:ReportService) { }

  id:number;
  report:Report=new Report();


  ngOnInit(): void 
  {
    this.id = this.route.snapshot.params['id'];
    this.reportService.getReportById(this.id).subscribe(data=>{this.report=data},
      error=>console.log(error));
  }

  onSubmit()
  {
    this.reportService.updateReport(this.id,this.report).subscribe(()=>
    {
    alert("Updated successfully");
    this.goToReportDetails();
    },
    error=>console.log(error));
  }

  goToReportDetails()
  {
    this.router.navigate(['/report-details',this.id]);
  }

  goBack()
  {
    this.router.navigate(['report-list']);
  }

}
