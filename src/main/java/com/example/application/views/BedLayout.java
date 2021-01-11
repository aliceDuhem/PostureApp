package com.example.application.views;

import com.example.application.backend.entity.Bed;
import com.example.application.backend.entity.Patient;
import com.example.application.backend.service.PatientService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.progressbar.ProgressBarVariant;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class BedLayout extends VerticalLayout {

    //NumberField bedNum = new NumberField();
    double bedNum;

    public BedLayout(Bed bed){

        // creates a layout for the header for each bed
        VerticalLayout bedHeader = new VerticalLayout();
        bedHeader.setAlignItems(Alignment.CENTER);
        // adds a bed number title to each header
        bedHeader.add(new H3("Bed " + (int)bed.getBedNum()));

        if(bed.isEmpty()){
            // if the bed is empty it adds and empty bed layout
            add(
                    bedHeader,
                    new Label("This Bed is Empty")
            );
        } else {

            // adds fields to show the name, braden score and time on position of the patient
            TextField name = new TextField("Name");
            NumberField bScore = new NumberField("Braden Score");
            TextField timeInPosField = new TextField("Time in pos");
            HorizontalLayout headerLine = new HorizontalLayout();
            HorizontalLayout infoLine = new HorizontalLayout();

            // creates the progress bar and sets the status of it from the bed
            ProgressBar progressBar = new ProgressBar(0,100,bed.getStatus());
            // changes the colour of the bar based on its status
            if(bed.getStatus() < 33) {
                // bar is green
                progressBar.addThemeVariants(ProgressBarVariant.LUMO_SUCCESS);
            }
            else if(bed.getStatus() < 66){
                // bar is black
                progressBar.addThemeVariants(ProgressBarVariant.LUMO_CONTRAST);
            } else {
                // bar is red
                progressBar.addThemeVariants(ProgressBarVariant.LUMO_ERROR);
            }

            progressBar.setHeight("20px");

            name.setValue(bed.getPatient().getName());
            bScore.setValue(bed.getPatient().getbScore());
            timeInPosField.setValue((int)Math.floor(bed.getTimeInPos()/60) + "h " + (int)Math.floor(bed.getTimeInPos()%60) + "m");

            name.setReadOnly(true);
            name.setWidth("175px");
            bScore.setWidth("100px");
            bScore.setReadOnly(true);
            timeInPosField.setWidth("100px");
            timeInPosField.setReadOnly(true);

            infoLine.add(name,bScore,timeInPosField);
            add(
                    bedHeader,
                    infoLine,
                    progressBar
            );
        }

        Binder <Bed> bedBinder = new Binder<>(Bed.class);
        bedBinder.bindInstanceFields(this);
        bedBinder.setBean(bed);
    }
}
