import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/class/patient';
import { PatientService } from '../../../services/patient.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent implements OnInit {

  id:number;
  patient:Patient=new Patient();

  constructor(private route: ActivatedRoute,private patientService:PatientService,private router:Router) { }

  ngOnInit(): void 
  {
    this.id = this.route.snapshot.params['id'];
    this.patientService.getPatientById(this.id).subscribe(data=>this.patient=data);
  }

  goToPatientList(){
    this.router.navigate(['/patient-list']);
  }

  updatePatient(id:number)
  {
    this.router.navigate(['update-patient', id]);
  }

  deletePatient(id:number)
  {
    this.patientService.deletePatient(id).subscribe();
    alert("Patient has deleted successfully");
    this.goToPatientList();
  }

}
