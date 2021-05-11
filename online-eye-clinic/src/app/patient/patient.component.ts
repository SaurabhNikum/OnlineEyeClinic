import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Appointment } from '../class/appointment';
import { Patient } from '../class/patient';
import { Report } from '../class/report';
import { AppointmentService } from '../services/appointment.service';
import { PatientService } from '../services/patient.service';
import { ReportService } from '../services/report.service';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  constructor(private patientService:PatientService,private appointmentService:AppointmentService,
    private reportService:ReportService,private route:ActivatedRoute,private router:Router) { }

  id:number;
  patient:Patient=new Patient();
  appointments:Appointment[];
  reports:Report[];


  ngOnInit(): void 
  {
    this.id = this.route.snapshot.params['id'];
    document.getElementById("alist").style.visibility="hidden";
    document.getElementById("rlist").style.visibility="hidden";
    this.patientService.getPatientById(this.id).subscribe(data=>this.patient=data);
    this.appointmentService.getAppointmentByPatient(this.id).subscribe(data=>this.appointments=data);
    this.reportService.getReportByPatientId(this.id).subscribe(data=>this.reports=data);
  }

  showAppointmentList()
  {
    document.getElementById("alist").style.visibility="visible";
  }

  hideAppointmentList()
  {
    document.getElementById("alist").style.visibility="hidden";
  }

  showReportList()
  {
    document.getElementById("rlist").style.visibility="visible";
  }

  requestAppointment(id:number,email:string)
  {
    this.router.navigate(['request-appointment',id,email]);
  }

  hideReportList()
  {
    document.getElementById("rlist").style.visibility="hidden";
  }

  updatePatient(id:number)
  {
    this.router.navigate(['update-patient', id]);
  }

  deletePatient(id:number)
  {
    this.patientService.deletePatient(id).subscribe();
    alert("Account has deleted successfully");
    this.router.navigate(["/home"]);
  }



}
