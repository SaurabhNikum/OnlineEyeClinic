import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Patient } from 'src/app/class/patient';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registrationForm: FormGroup;  
  isSubmitted: boolean = false;  
  
  constructor(private formBuilder: FormBuilder,private router:Router,private patientService:PatientService) {  
    this.registrationForm = this.formBuilder.group({ 

      name: new FormControl('', [  
        Validators.required,  
        Validators.minLength(3),  
        Validators.maxLength(30),  
        Validators.pattern('^[a-zA-Z ]*$')]),

        age: new FormControl('', [  
          Validators.required,  
          Validators.min(1),
          Validators.max(150)]),

        address: new FormControl('', [  
          Validators.required,  
          Validators.minLength(2),  
          Validators.maxLength(50)  
          ]),  

        username: new FormControl('', [  
          Validators.required,  
          Validators.minLength(6),  
          Validators.maxLength(20),  
          Validators.pattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}$")]),  
        
        
      phoneNumber: new FormControl('', [  
        Validators.required,  
        Validators.minLength(8),  
        Validators.maxLength(12),  
        Validators.pattern('^[6-9][0-9]{9}$')]),

      email: new FormControl('', [  
        Validators.required,  
        Validators.minLength(8),  
        Validators.maxLength(80),  
        Validators.pattern("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$")  
      ]),  

      password: new FormControl('', [  
        Validators.required,  
        Validators.minLength(8),  
        Validators.maxLength(20),
        Validators.pattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&]).{8,20}$")          
      ])  
    });    
  }  
 

  ngOnInit() 
  {  
    
  }  
  patient:Patient=new Patient();
  
  onRegistrationFormSubmit() {  
    this.isSubmitted = true;  
    if(this.registrationForm.valid){
      this.createPatient();       
    }  
      
  }  

  createPatient()
  {
    this.patient.patientId=0;
    this.patient.age=this.registrationForm.get(`age`).value;
    this.patient.name=this.registrationForm.get(`name`).value;
    this.patient.userName=this.registrationForm.get(`username`).value;
    this.patient.password=this.registrationForm.get(`password`).value;
    this.patient.address=this.registrationForm.get(`address`).value;
    this.patient.email=this.registrationForm.get(`email`).value;
    this.patient.mobile=this.registrationForm.get(`phoneNumber`).value;
    this.patientService.createPatient(this.patient).subscribe(data=>
      {
        alert("Registation Successful !!! Username : "+this.registrationForm.get(`username`).value);
        this.router.navigate(['home/login']);
      },
    error=>console.log(error));
  }

}
