import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorService } from 'src/app/services/doctor.service';
import { LoginService } from 'src/app/services/login.service';
import { PatientService } from 'src/app/services/patient.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router:Router,private patientService:PatientService,private loginService:LoginService,private doctorService:DoctorService) { }
  
  username:string='';
  password:string='';
  selectedUser: string;
  sdId:any;
  spId:any;
  dId:number;
  pId:number;
  //event handler for the select element's change event
  selectChangeHandler (event: any) {
    //update the ui
    this.selectedUser = event.target.value;
  }

  ngOnInit(): void {
  }
  onSubmit() 
  {
      if(this.selectedUser=="Doctor")
      { 
        this.checkDoctorCredential();
      }
      else if(this.selectedUser=="Admin")
      {
        this.checkAdminCredential();
      }
      else if(this.selectedUser=="Patient")
      {
        this.checkPatientCredential();
      }
  }


  checkAdminCredential()
  {
    this.loginService.getAdminLogin(this.username, this.password).subscribe(
      data => {
        if (data == true) {
          alert("Logged in successfully");
          this.router.navigate(['admin-service']);
        }
        else {
          alert("Invalid username or password !! try Again");
        }
      },
      error => console.log(error));
  }

  checkDoctorCredential()
  {
    this.loginService.getDoctorLogin(this.username, this.password).subscribe(
      data => {
        if (data == true) {
         alert("Logged in successfully");
         this.doctorService.getDoctorIdByUsername(this.username).subscribe(data => 
        {
         this.sdId = data;
         this.dId=parseInt(this.sdId,10);
         this.router.navigate(['/doctoruser',this.dId]);
        },
        error=>console.log(error));
      }
        else {
         alert("Invalid username or password !! try Again");
       }
      },
      error => console.log(error));
  }

  checkPatientCredential()
  {
    this.loginService.getPatientLogin(this.username, this.password).subscribe(
      data => {
        if (data == true) {
         alert("Logged in successfully");
         this.patientService.getPatientIdByUserName(this.username).subscribe(data => 
        {
          this.spId = data;
          this.pId=parseInt(this.spId,10);
         this.router.navigate(['/patientuser',this.pId]);
        },
        error=>console.log(error));
      }
        else {
         alert("Invalid username or password !! try Again");
       }
      },
      error => console.log(error));
  }
  
  
}
