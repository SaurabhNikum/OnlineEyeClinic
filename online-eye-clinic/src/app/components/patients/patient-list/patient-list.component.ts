import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from 'src/app/class/patient';
import { PatientService } from '../../../services/patient.service';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  patients:Patient[];
  name:string;

  constructor(private router:Router,private patientService:PatientService) { }

  ngOnInit(): void 
  {
    this.getPatient();
  }

  patientByName()
  {
    this.patientService.getPatientsByName(this.name).subscribe(data=>this.patients=data);
  }

  getPatient()
  {
    this.patientService.getPatientList().subscribe(data=>this.patients=data);
  }

  patientDetails(id:number)
  {
    this.router.navigate(['patient-details', id]);
  }

  updatePatient(id:number)
  {
    this.router.navigate(['update-patient', id]);
  }

  deletePatient(id:number)
  {
    this.patientService.deletePatient(id).subscribe();
    alert("Patient has deleted successfully");
    this.getPatient();
  }

}
