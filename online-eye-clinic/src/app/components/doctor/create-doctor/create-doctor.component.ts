import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Doctor } from 'src/app/class/doctor';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-create-doctor',
  templateUrl: './create-doctor.component.html',
  styleUrls: ['./create-doctor.component.css']
})
export class CreateDoctorComponent implements OnInit {

  registrationForm: FormGroup;  
  isSubmitted: boolean = false;  
  
  constructor(private router: Router,private doctorService:DoctorService,private formBuilder: FormBuilder) 
  {
    this.registrationForm = this.formBuilder.group({ 

      name: new FormControl('', [  
        Validators.required,  
        Validators.minLength(3),  
        Validators.maxLength(30),  
        Validators.pattern('^[a-zA-Z ]*$')]),

        cTime: new FormControl('', [  
          Validators.required]), 
      

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

  doctor:Doctor=new Doctor();

  makeDoctor()
  {
    this.doctor.doctorId=0;
    this.doctor.name=this.registrationForm.get(`name`).value;
    this.doctor.userName=this.registrationForm.get(`username`).value;
    this.doctor.password=this.registrationForm.get(`password`).value;
    this.doctor.mobile=this.registrationForm.get(`phoneNumber`).value;
    this.doctor.email=this.registrationForm.get(`email`).value;
    this.doctor.consultationTime=this.registrationForm.get(`cTime`).value;
    this.doctor.address=this.registrationForm.get(`address`).value;
    this.doctorService.createDoctor(this.doctor).subscribe(data=>
      {
        alert("Registation Successful !!! Username : "+this.registrationForm.get(`username`).value);
        this.router.navigate(['doctor-list']);
      },
    error=>console.log(error));
  }
  

  ngOnInit(): void {
  }

  onRegistrationFormSubmit() {  
    this.isSubmitted = true;  
    if(this.registrationForm.valid){
      this.makeDoctor();       
    } 
  } 

}
