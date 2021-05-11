import { Component, OnInit } from '@angular/core';
import { Spectacle } from '../../../class/spectacle';
import { SpectacleService } from '../../../services/spectacle.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-spectacle',
  templateUrl: './create-spectacle.component.html',
  styleUrls: ['./create-spectacle.component.css']
})
export class CreateSpectacleComponent implements OnInit {

  constructor(private router: Router,private spectacleService:SpectacleService) { }

  spectacle:Spectacle=new Spectacle();

  ngOnInit(): void {
  }

  saveSpectacle()
  {
      this.spectacleService.addSpectacle(this.spectacle).subscribe(data=>{
      console.log(data);
      alert("Spectacle has added successfully");
      this.spectacle=new Spectacle();
      this.goToSpectacleList();
    },
    error=>console.log(error));
  }
  
  goToSpectacleList(){
    this.router.navigate(['/spectacle-list']);
  }

  onSubmit(){
    console.log(this.spectacle);
    this.saveSpectacle();
  }

}
