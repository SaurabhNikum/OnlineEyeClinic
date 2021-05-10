import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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
    private reportService:ReportService,private route:ActivatedRoute) { }

  id:number;
  patient:Patient=new Patient();
  appointments:Appointment[];
  reports:Report[];


  ngOnInit(): void 
  {
    this.id = this.route.snapshot.params['id'];
    this.patientService.getPatientById(this.id).subscribe(data=>this.patient=data);
    this.appointmentService.getAppointmentByPatient(this.id).subscribe(data=>this.appointments=data);
    this.reportService.getReportByPatientId(this.id).subscribe(data=>this.reports=data);
  }



}
