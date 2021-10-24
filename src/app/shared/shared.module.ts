import { NgModule } from "@angular/core";
import { FlexLayoutModule } from "@angular/flex-layout";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MaterialModule } from "./material.module";

@NgModule({
    imports: [
        MaterialModule,
        FlexLayoutModule,
        FormsModule,
        ReactiveFormsModule,
    ],
    declarations: [],
    providers: [],
    exports: [
        MaterialModule,
        FlexLayoutModule,
        FormsModule,
        ReactiveFormsModule,
    ]
})
export class SharedModule {}