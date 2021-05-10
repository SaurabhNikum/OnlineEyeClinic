import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Report } from 'src/app/class/report';
import { ReportService } from 'src/app/services/report.service';

@Component({
  selector: 'app-report-details',
  templateUrl: './report-details.component.html',
  styleUrls: ['./report-details.component.css']
})
export class ReportDetailsComponent implements OnInit {

  constructor(private route: ActivatedRoute,private reportService:ReportService,private router:Router) { }

  id:number;
  report:Report;
  ngOnInit(): void 
  {
    this.id = this.route.snapshot.params['id'];
    this.report=new Report();
    this.reportService.getReportById(this.id).subscribe(data=>this.report=data);
  }

  goToReportList(){
    this.router.navigate(['/report-list']);
  }

  updateReport(id:number)
  {
    this.router.navigate(['/update-report', id]);
  }

  deleteReport(id:number)
  {
    this.reportService.deleteReport(this.id).subscribe();
    alert("Report has deleted successfully");
    this.goToReportList();
  }
}
