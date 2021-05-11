import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreateTestsComponent } from './components/tests/create-tests/create-tests.component';
import { TestsDetailsComponent } from './components/tests/tests-details/tests-details.component';
import { TestsListComponent } from './components/tests/tests-list/tests-list.component';
import { UpdateTestsComponent } from './components/tests/update-tests/update-tests.component';
import { CreatePatientComponent } from './components/patients/create-patient/create-patient.component';
import { UpdatePatientComponent } from './components/patients/update-patient/update-patient.component';
import { PatientDetailsComponent } from './components/patients/patient-details/patient-details.component';
import { PatientListComponent } from './components/patients/patient-list/patient-list.component';
import { CreateSpectacleComponent } from './components/spectacles/create-spectacle/create-spectacle.component';
import { UpdateSpectacleComponent } from './components/spectacles/update-spectacle/update-spectacle.component';
import { SpectacleListComponent } from './components/spectacles/spectacle-list/spectacle-list.component';
import { SpectacleDetailsComponent } from './components/spectacles/spectacle-details/spectacle-details.component';
import { CreateReportComponent } from './components/reports/create-report/create-report.component';
import { UpdateReportComponent } from './components/reports/update-report/update-report.component';
import { ReportDetailsComponent } from './components/reports/report-details/report-details.component';
import { ReportListComponent } from './components/reports/report-list/report-list.component';
import { CreateDoctorComponent } from './components/doctor/create-doctor/create-doctor.component';
import { UpdateDoctorComponent } from './components/doctor/update-doctor/update-doctor.component';
import { DoctorListComponent } from './components/doctor/doctor-list/doctor-list.component';
import { DoctorDetailsComponent } from './components/doctor/doctor-details/doctor-details.component';
import { CreateAppointmentComponent } from './components/appointments/create-appointment/create-appointment.component';
import { UpdateAppointmentComponent } from './components/appointments/update-appointment/update-appointment.component';
import { AppointmentDetailsComponent } from './components/appointments/appointment-details/appointment-details.component';
import { AppointmentListComponent } from './components/appointments/appointment-list/appointment-list.component';
import { HomeComponentComponent } from './components/home-component/home-component.component';
import { TestListUserComponent } from './components/user/test-list-user/test-list-user.component';
import { SpectacleListUserComponent } from './components/user/spectacle-list-user/spectacle-list-user.component';
import { DoctorListUserComponent } from './components/user/doctor-list-user/doctor-list-user.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminComponent } from './components/admin/admin.component';
import { RegisterComponent } from './components/register/register.component';
import { DoctorComponent } from './doctor/doctor.component';
import { PatientComponent } from './patient/patient.component';
import { LoginComponent} from './components/login/login.component';
import { EmailComponent } from './components/email/email.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { AppointmentRequestComponent } from './compnents/appointment-request/appointment-request.component';
import { RequestListComponent } from './components/appointmentRequest/request-list/request-list.component';
import { RegretionEmailComponent } from './regretion-email/regretion-email.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateTestsComponent,
    TestsDetailsComponent,
    TestsListComponent,
    UpdateTestsComponent,
    CreatePatientComponent,
    UpdatePatientComponent,
    PatientDetailsComponent,
    PatientListComponent,
    CreateSpectacleComponent,
    UpdateSpectacleComponent,
    SpectacleListComponent,
    SpectacleDetailsComponent,
    CreateReportComponent,
    UpdateReportComponent,
    ReportDetailsComponent,
    ReportListComponent,
    CreateDoctorComponent,
    UpdateDoctorComponent,
    DoctorListComponent,
    DoctorDetailsComponent,
    CreateAppointmentComponent,
    UpdateAppointmentComponent,
    AppointmentDetailsComponent,
    AppointmentListComponent,
    HomeComponentComponent,
    TestListUserComponent,
    SpectacleListUserComponent,
    DoctorListUserComponent,
    AdminComponent,
    RegisterComponent,
    DoctorComponent,
    PatientComponent,
    LoginComponent,
    EmailComponent,
    AppointmentRequestComponent,
    RequestListComponent,
    RegretionEmailComponent
    
   
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
