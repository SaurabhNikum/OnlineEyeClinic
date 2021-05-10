import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Spectacle } from 'src/app/class/spectacle';
import { SpectacleService } from 'src/app/services/spectacle.service';

@Component({
  selector: 'app-spectacle-list-user',
  templateUrl: './spectacle-list-user.component.html',
  styleUrls: ['./spectacle-list-user.component.css']
})
export class SpectacleListUserComponent implements OnInit {

  constructor(private spectacleService:SpectacleService,private router:Router) { }

  spectacles:Spectacle[];
  model:string;

  ngOnInit(): void 
  {
    this.getSpectacle();
  }

  getSpectacle()
  {
    this.spectacleService.getSpectacles().subscribe(data=>this.spectacles=data);
  }

  spectacleByModel()
  {
    this.spectacleService.getSpectacleByModel(this.model).subscribe(data=>this.spectacles=data);
  }

}
