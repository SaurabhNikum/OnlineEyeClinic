import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { AppointmentDetailsComponent } from './components/appointments/appointment-details/appointment-details.component';
import { AppointmentListComponent } from './components/appointments/appointment-list/appointment-list.component';
import { CreateAppointmentComponent } from './components/appointments/create-appointment/create-appointment.component';
import { CreateDoctorComponent } from './components/doctor/create-doctor/create-doctor.component';
import { DoctorDetailsComponent } from './components/doctor/doctor-details/doctor-details.component';
import { DoctorListComponent } from './components/doctor/doctor-list/doctor-list.component';
import { UpdateDoctorComponent } from './components/doctor/update-doctor/update-doctor.component';
import { HomeComponentComponent } from './components/home-component/home-component.component';
import { CreatePatientComponent } from './components/patients/create-patient/create-patient.component';
import { PatientDetailsComponent } from './components/patients/patient-details/patient-details.component';
import { PatientListComponent } from './components/patients/patient-list/patient-list.component';
import { UpdatePatientComponent } from './components/patients/update-patient/update-patient.component';
import { CreateReportComponent } from './components/reports/create-report/create-report.component';
import { ReportDetailsComponent } from './components/reports/report-details/report-details.component';
import { ReportListComponent } from './components/reports/report-list/report-list.component';
import { UpdateReportComponent } from './components/reports/update-report/update-report.component';
import { CreateSpectacleComponent } from './components/spectacles/create-spectacle/create-spectacle.component';
import { SpectacleDetailsComponent } from './components/spectacles/spectacle-details/spectacle-details.component';
import { SpectacleListComponent } from './components/spectacles/spectacle-list/spectacle-list.component';
import { UpdateSpectacleComponent } from './components/spectacles/update-spectacle/update-spectacle.component';
import { CreateTestsComponent } from './components/tests/create-tests/create-tests.component';
import { TestsDetailsComponent } from './components/tests/tests-details/tests-details.component';
import { TestsListComponent } from './components/tests/tests-list/tests-list.component';
import { UpdateTestsComponent } from './components/tests/update-tests/update-tests.component';



const routes: Routes = [
  {path:"",redirectTo:"home",pathMatch:"full"},
  {path:"home",component:HomeComponentComponent},
  {path: 'create-tests', component: CreateTestsComponent},
  {path: 'update-tests/:id', component: UpdateTestsComponent},
  {path: 'tests-details/:id', component: TestsDetailsComponent},
  {path: 'tests-list', component: TestsListComponent},
  {path: 'create-patient', component: CreatePatientComponent},
  {path: 'update-patient/:id', component: UpdatePatientComponent},
  {path: 'patient-details/:id', component: PatientDetailsComponent},
  {path: 'patient-list', component: PatientListComponent},
  {path: 'create-doctor', component: CreateDoctorComponent},
  {path: 'update-doctor/:id', component: UpdateDoctorComponent},
  {path: 'doctor-details/:id', component: DoctorDetailsComponent},
  {path: 'doctor-list', component: DoctorListComponent},
  {path: 'create-spectacle', component: CreateSpectacleComponent},
  {path: 'update-spectacle/:id', component: UpdateSpectacleComponent},
  {path: 'spectacle-details/:id', component: SpectacleDetailsComponent},
  {path: 'spectacle-list', component: SpectacleListComponent},
  {path: 'create-report', component: CreateReportComponent},
  {path: 'update-report/:id', component: UpdateReportComponent},
  {path: 'report-details/:id', component: ReportDetailsComponent},
  {path: 'report-list', component: ReportListComponent},
  {path: 'create-appointment', component: CreateAppointmentComponent},
  {path: 'appointment-details/:id', component: AppointmentDetailsComponent},
  {path: 'appointment-list', component: AppointmentListComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }