import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Report } from 'src/app/class/report';
import { ReportService } from 'src/app/services/report.service';

@Component({
  selector: 'app-create-report',
  templateUrl: './create-report.component.html',
  styleUrls: ['./create-report.component.css']
})
export class CreateReportComponent implements OnInit {

  constructor(private router: Router,private reportService:ReportService) { }

  report:Report=new Report();

  ngOnInit(): void {
  }
  
  saveReport()
  {
    this.reportService.createReport(this.report).subscribe(data=>{
      console.log(data);
      alert("Report has added successfully");
      this.report=new Report();
    },
    error=>console.log(error));
  }
  
  goToReportList(){
    this.router.navigate(['/report-list']);
  }

  onSubmit(){
    console.log(this.report);
    this.saveReport();
  }
}

