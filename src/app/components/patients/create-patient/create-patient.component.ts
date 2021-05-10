import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from 'src/app/class/patient';
import { PatientService } from '../../../services/patient.service';

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.css']
})
export class CreatePatientComponent implements OnInit {

  constructor(private router: Router,private patientService:PatientService) { }

  patient:Patient=new Patient();

  ngOnInit(): void {
  }

  savePatient()
  {
    this.patientService.createPatient(this.patient).subscribe(data=>{
      console.log(data);
      alert("Patient has added successfully");
      this.patient=new Patient();
    },
    error=>console.log(error));
  }
  
  goToPatientList(){
    this.router.navigate(['/patient-list']);
  }

  onSubmit(){
    console.log(this.patient);
    this.savePatient();
  }


}
