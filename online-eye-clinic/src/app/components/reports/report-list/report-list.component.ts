import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Report } from 'src/app/class/report';
import { ReportService } from 'src/app/services/report.service';

@Component({
  selector: 'app-report-list',
  templateUrl: './report-list.component.html',
  styleUrls: ['./report-list.component.css']
})
export class ReportListComponent implements OnInit {

  pId:number;
  reports:Report[];
  constructor(private reportService:ReportService,private router:Router) { }

  ngOnInit(): void 
  {
    this.getReports();
  }

  getReports()
  {
    this.reportService.getReportList().subscribe(data=>this.reports=data);
  }

  reportDetails(id:number)
  {
    this.router.navigate(['report-details', id]);
  }

  updateReport(id:number)
  {
    this.router.navigate(['update-report', id]);
  }

  deleteReport(id:number)
  {
    this.reportService.deleteReport(id).subscribe(
      data=>{alert("Report has deleted successfully");},
      error=>{
        console.log(error);
        alert("Deletion failed");}
    );
    this.getReports();
  }

}
