import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/class/patient';
import { PatientService } from '../../../services/patient.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrls: ['./update-patient.component.css']
})
export class UpdatePatientComponent implements OnInit {


  id:number;
  errorMessage:string;
  patient:Patient=new Patient();

  constructor(private route: ActivatedRoute,private router: Router,private patientService:PatientService) { }

  ngOnInit(): void 
  {
    this.id = this.route.snapshot.params['id'];
    this.patientService.getPatientById(this.id).subscribe(data=>
      {this.patient=data},
      error=>this.errorMessage=error);

      
  }

  onSubmit()
  {
    this.patientService.updatePatient(this.id,this.patient).subscribe(
      ()=>
      {
        alert("Updated Successfully");
        this.goBack();
      },
      error=>
      {
        alert("Updation failed");
        console.log(error);
      }
    );
  }
  goBack()
  {
    this.router.navigate(['/patientuser',this.id]);
  }

}
