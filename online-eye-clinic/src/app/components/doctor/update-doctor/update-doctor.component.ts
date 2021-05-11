import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Doctor } from 'src/app/class/doctor';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-update-doctor',
  templateUrl: './update-doctor.component.html',
  styleUrls: ['./update-doctor.component.css']
})
export class UpdateDoctorComponent implements OnInit {

  id:number;
  doctor:Doctor=new Doctor();

  constructor(private route: ActivatedRoute,private router: Router,private doctorService:DoctorService) { }

  ngOnInit(): void 
  {
    this.id = this.route.snapshot.params['id'];
    this.doctorService.getDoctorById(this.id).subscribe(data=>this.doctor=data);
  }

  goBack()
  {
    this.router.navigate(['/doctoruser',this.id]);
  }

  

  onSubmit()
  {
    this.doctorService.updateDoctor(this.id,this.doctor).subscribe(
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

  goToDoctorDetails()
  {
    this.router.navigate(['/doctor-details',this.id]);
  }
}
