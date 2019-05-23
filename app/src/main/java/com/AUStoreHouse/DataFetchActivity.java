package com.AUStoreHouse;

import android.app.DownloadManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.AUStoreHouse.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


import java.util.ArrayList;
import java.util.List;

public class DataFetchActivity extends AppCompatActivity {

    DatabaseReference dbFiles;

    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;
    ListView listView;
    ArrayList<data> person;
    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_fetch);

        person = new ArrayList<>();
        dbFiles = FirebaseDatabase.getInstance().getReference("Syllabus");
        listView = findViewById(R.id.listView);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-5040215542785098/7772471017");
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener(){
            public void onAdLoaded(){
                displayInterstitial();
            }
        });
        int key = getIntent().getIntExtra("key",-1);
        TextView te = findViewById(R.id.data);

        switch(key){
            //Sem 1
            case 12:
                //te.setText("(Sem 1)Syllabus for CSE Downloading...");
                person.add(new data("CommunicativeEnglish_HS8151.docx","Syllabus/Common/CommunicativeEnglish_HS8151.docx"));
                person.add(new data("EngineeringChemistry_CY8151.docx","Syllabus/Common/EngineeringChemistry_CY8151.docx"));
                person.add(new data("EngineeringGraphics_GE8151.docx","Syllabus/Common/EngineeringGraphics_GE8151.docx"));
                person.add(new data("EngineeringMathematics_MA8151.docx","Syllabus/Common/EngineeringMathematics_MA8151.docx"));
                person.add(new data("EngineeringPhysics_PH8151.docx","Syllabus/Common/EngineeringPhysics_PH.docx"));
                person.add(new data("ProblemSolvingAndPythonProgramming_GE8151.docx","Syllabus/Common/ProblemSolvingAndPythonProgramming_GE8151.docx"));
//
//                dbFiles.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                        person.clear();
//                        for(DataSnapshot da : dataSnapshot.getChildren()){
//                            data dara = da.getValue(data.class);
//                            person.add(dara);
//                        }
//                        dataAdapter da = new dataAdapter(DataFetchActivity.this,person);
//                        listView.setAdapter(da);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
//
                syll();
                break;
            case 02:
                //te.setText("(Sem 1)Question Paper for CSE Downloading...");
                person.add(new data("CommunicativeEnglish_2018.pdf","QuestionPaper/Common/CommunicativeEnglish_2018.pdf"));
                person.add(new data("Engineering_Chemistry_2018.pdf","QuestionPaper/Common/Engineering_Chemistry_2018.pdf"));
                person.add(new data("Engineering_Physics_2018.pdf","QuestionPaper/Common/Engineering_Physics_2018.pdf"));
                person.add(new data("EngineeringGraphics_1_2018.pdf","QuestionPaper/Common/EngineeringGraphics_1_2018.pdf"));
                person.add(new data("EngineeringGraphics_2_2018.pdf","QuestionPaper/Common/EngineeringGraphics_2_2018.pdf"));
                person.add(new data("EngineeringMathematics_2018.pdf","QuestionPaper/Common/EngineeringMathematics_2018.pdf"));
                person.add(new data("PSPP_2018.pdf","QuestionPaper/Common/PSPP_2018.pdf"));
                syll();
                break;

            case 15:
                //te.setText("(Sem 1)Syllabus for ECE Downloading...");
                person.add(new data("CommunicativeEnglish_HS8151.docx","Syllabus/Common/CommunicativeEnglish_HS8151.docx"));
                person.add(new data("EngineeringChemistry_CY8151.docx","Syllabus/Common/EngineeringChemistry_CY8151.docx"));
                person.add(new data("EngineeringGraphics_GE8151.docx","Syllabus/Common/EngineeringGraphics_GE8151.docx"));
                person.add(new data("EngineeringMathematics_MA8151.docx","Syllabus/Common/EngineeringMathematics_MA8151.docx"));
                person.add(new data("EngineeringPhysics_PH8151.docx","Syllabus/Common/EngineeringPhysics_PH.docx"));
                person.add(new data("ProblemSolvingAndPythonProgramming_GE8151.docx","Syllabus/Common/ProblemSolvingAndPythonProgramming_GE8151.docx"));
                syll();

                break;

            case 5:
                //te.setText("(Sem 1)Question Paper for ECE Downloading...");
                person.add(new data("CommunicativeEnglish_2018.pdf","QuestionPaper/Common/CommunicativeEnglish_2018.pdf"));
                person.add(new data("Engineering_Chemistry_2018.pdf","QuestionPaper/Common/Engineering_Chemistry_2018.pdf"));
                person.add(new data("Engineering_Physics_2018.pdf","QuestionPaper/Common/Engineering_Physics_2018.pdf"));
                person.add(new data("EngineeringGraphics_1_2018.pdf","QuestionPaper/Common/EngineeringGraphics_1_2018.pdf"));
                person.add(new data("EngineeringGraphics_2_2018.pdf","QuestionPaper/Common/EngineeringGraphics_2_2018.pdf"));
                person.add(new data("EngineeringMathematics_2018.pdf","QuestionPaper/Common/EngineeringMathematics_2018.pdf"));
                person.add(new data("PSPP_2018.pdf","QuestionPaper/Common/PSPP_2018.pdf"));
                syll();

                break;

            case 18:
                //te.setText("(Sem 1)Syllabus for EEE Downloading...");
                person.add(new data("CommunicativeEnglish_HS8151.docx","Syllabus/Common/CommunicativeEnglish_HS8151.docx"));
                person.add(new data("EngineeringChemistry_CY8151.docx","Syllabus/Common/EngineeringChemistry_CY8151.docx"));
                person.add(new data("EngineeringGraphics_GE8151.docx","Syllabus/Common/EngineeringGraphics_GE8151.docx"));
                person.add(new data("EngineeringMathematics_MA8151.docx","Syllabus/Common/EngineeringMathematics_MA8151.docx"));
                person.add(new data("EngineeringPhysics_PH8151.docx","Syllabus/Common/EngineeringPhysics_PH.docx"));
                person.add(new data("ProblemSolvingAndPythonProgramming_GE8151.docx","Syllabus/Common/ProblemSolvingAndPythonProgramming_GE8151.docx"));
                syll();

                break;

            case 8:
                //te.setText("(Sem 1)Question Paper for EEE Downloading...");
                person.add(new data("CommunicativeEnglish_2018.pdf","QuestionPaper/Common/CommunicativeEnglish_2018.pdf"));
                person.add(new data("Engineering_Chemistry_2018.pdf","QuestionPaper/Common/Engineering_Chemistry_2018.pdf"));
                person.add(new data("Engineering_Physics_2018.pdf","QuestionPaper/Common/Engineering_Physics_2018.pdf"));
                person.add(new data("EngineeringGraphics_1_2018.pdf","QuestionPaper/Common/EngineeringGraphics_1_2018.pdf"));
                person.add(new data("EngineeringGraphics_2_2018.pdf","QuestionPaper/Common/EngineeringGraphics_2_2018.pdf"));
                person.add(new data("EngineeringMathematics_2018.pdf","QuestionPaper/Common/EngineeringMathematics_2018.pdf"));
                person.add(new data("PSPP_2018.pdf","QuestionPaper/Common/PSPP_2018.pdf"));
                syll();

                break;

            case 21:
                //te.setText("(Sem 1)Syllabus for Civil Downloading...");
                person.add(new data("CommunicativeEnglish_HS8151.docx","Syllabus/Common/CommunicativeEnglish_HS8151.docx"));
                person.add(new data("EngineeringChemistry_CY8151.docx","Syllabus/Common/EngineeringChemistry_CY8151.docx"));
                person.add(new data("EngineeringGraphics_GE8151.docx","Syllabus/Common/EngineeringGraphics_GE8151.docx"));
                person.add(new data("EngineeringMathematics_MA8151.docx","Syllabus/Common/EngineeringMathematics_MA8151.docx"));
                person.add(new data("EngineeringPhysics_PH8151.docx","Syllabus/Common/EngineeringPhysics_PH.docx"));
                person.add(new data("ProblemSolvingAndPythonProgramming_GE8151.docx","Syllabus/Common/ProblemSolvingAndPythonProgramming_GE8151.docx"));
                syll();

                break;

            case 11:
                //te.setText("(Sem 1)Question Paper for Civil Downloading...");
                person.add(new data("CommunicativeEnglish_2018.pdf","QuestionPaper/Common/CommunicativeEnglish_2018.pdf"));
                person.add(new data("Engineering_Chemistry_2018.pdf","QuestionPaper/Common/Engineering_Chemistry_2018.pdf"));
                person.add(new data("Engineering_Physics_2018.pdf","QuestionPaper/Common/Engineering_Physics_2018.pdf"));
                person.add(new data("EngineeringGraphics_1_2018.pdf","QuestionPaper/Common/EngineeringGraphics_1_2018.pdf"));
                person.add(new data("EngineeringGraphics_2_2018.pdf","QuestionPaper/Common/EngineeringGraphics_2_2018.pdf"));
                person.add(new data("EngineeringMathematics_2018.pdf","QuestionPaper/Common/EngineeringMathematics_2018.pdf"));
                person.add(new data("PSPP_2018.pdf","QuestionPaper/Common/PSPP_2018.pdf"));
                syll();

                break;

            case 25:
                //te.setText("(Sem 1)Syllabus for Mech Downloading...");
                person.add(new data("CommunicativeEnglish_HS8151.docx","Syllabus/Common/CommunicativeEnglish_HS8151.docx"));
                person.add(new data("EngineeringChemistry_CY8151.docx","Syllabus/Common/EngineeringChemistry_CY8151.docx"));
                person.add(new data("EngineeringGraphics_GE8151.docx","Syllabus/Common/EngineeringGraphics_GE8151.docx"));
                person.add(new data("EngineeringMathematics_MA8151.docx","Syllabus/Common/EngineeringMathematics_MA8151.docx"));
                person.add(new data("EngineeringPhysics_PH8151.docx","Syllabus/Common/EngineeringPhysics_PH.docx"));
                person.add(new data("ProblemSolvingAndPythonProgramming_GE8151.docx","Syllabus/Common/ProblemSolvingAndPythonProgramming_GE8151.docx"));
                syll();

                break;

            case 150:
                //te.setText("(Sem 1)Question Paper for Mech Downloading...");
                person.add(new data("CommunicativeEnglish_2018.pdf","QuestionPaper/Common/CommunicativeEnglish_2018.pdf"));
                person.add(new data("Engineering_Chemistry_2018.pdf","QuestionPaper/Common/Engineering_Chemistry_2018.pdf"));
                person.add(new data("Engineering_Physics_2018.pdf","QuestionPaper/Common/Engineering_Physics_2018.pdf"));
                person.add(new data("EngineeringGraphics_1_2018.pdf","QuestionPaper/Common/EngineeringGraphics_1_2018.pdf"));
                person.add(new data("EngineeringGraphics_2_2018.pdf","QuestionPaper/Common/EngineeringGraphics_2_2018.pdf"));
                person.add(new data("EngineeringMathematics_2018.pdf","QuestionPaper/Common/EngineeringMathematics_2018.pdf"));
                person.add(new data("PSPP_2018.pdf","QuestionPaper/Common/PSPP_2018.pdf"));
                syll();

                break;

                //*******************************************
                 //Sem 2

            case 13:
                //te.setText("(Sem 2)Syllabus for CSE Downloading...");
                person.add(new data("BEEM_BE8255.docx","Syllabus/CSE/sem2/BEEM_BE8255.docx"));
                person.add(new data("EngineeringMathematics_II_MA8251.docx","Syllabus/CSE/sem2/EngineeringMathematics_MA8251.docx"));
                person.add(new data("EVS_GE8291.docx","Syllabus/CSE/sem2/EVS_GE8291.docx"));
                person.add(new data("PhysicsForInformationScience_PH8252.docx","Syllabus/CSE/sem2/PhysicsForInformationScience_PH8252.docx"));
                person.add(new data("ProgrammingInC_CS8251.docx","Syllabus/CSE/sem2/ProgrammingInC_CS8251.docx"));
                person.add(new data("TechnicalEnglish_HS8251.docx","Syllabus/CSE/sem2/TechnicalEnglish_HS8251.docx"));
                syll();

                break;
            case 03:
                //te.setText("(Sem 2)Question Paper for CSE Downloading...");
                person.add(new data("BEEM_2018.pdf","QuestionPaper/sem2/CSE/BEEM_2018.pdf"));
                person.add(new data("EngineeringMathematics_2018.pdf","QuestionPaper/sem2/CSE/EngineeringMathematics_2018.pdf"));
                person.add(new data("EngineeringPhysics_2018.pdf","QuestionPaper/sem2/CSE/EngineeringPhysics_2018.pdf"));
                person.add(new data("EVS_2018.pdf","QuestionPaper/sem2/CSE/EVS_2018.pdf"));
                person.add(new data("ProgrammingInC_2018.pdf","QuestionPaper/sem2/CSE/ProgrammingInC_2018.pdf"));
                person.add(new data("TechnicalEnglish_2018.pdf","QuestionPaper/sem2/CSE/TechnicalEnglish_2018.pdf"));
                syll();
                break;

            case 16:
                //te.setText("(Sem 2)Syllabus for ECE Downloading...");
                person.add(new data("BEIE_BE8254.docx","Syllabus/ECE/sem2/BEIE_BE8254.docx"));
                person.add(new data("CiruitAnalysis_EC8251.docx","Syllabus/ECE/sem2/CiruitAnalysis_EC8251.docx"));
                person.add(new data("ElectronicDevices_EC8252.docx","Syllabus/ECE/sem2/ElectronicDevices_EC8252.docx"));
                person.add(new data("EngineeringMathematics_II_MA8251.docx","Syllabus/ECE/sem2/EngineeringMathematics_II_MA8251.docx"));
                person.add(new data("PhysicsForElectronicsEngineering_PH8253.docx","Syllabus/ECE/sem2/PhysicsForElectronicsEngineering_PH8253.docx"));
                person.add(new data("TechnicalEnglish_HS8251.docx","Syllabus/ECE/sem2/TechnicalEnglish_HS8251.docx"));
                syll();
                break;
            case 6:
                //te.setText("(Sem 2)Question Paper for ECE Downloading...");
                person.add(new data("BEIE_2018.pdf","QuestionPaper/sem2/ECE/BEIE_2018.pdf"));
                person.add(new data("ED_2018.pdf","QuestionPaper/sem2/ECE/ED_2018.pdf"));
                person.add(new data("EngineeringMathematics_2018.pdf","QuestionPaper/sem2/ECE/EngineeringMathematics_2018.pdf"));
                person.add(new data("Physics_2018.pdf","QuestionPaper/sem2/ECE/Physics_2018.pdf"));
                person.add(new data("TechnicalEnglish_2018.pdf","QuestionPaper/sem2/ECE/TechnicalEnglish_2018.pdf"));
                syll();
                break;

            case 19:
                //te.setText("(Sem 2)Syllabus for EEE Downloading...");
                person.add(new data("BCME_BE8252.docx","Syllabus/EEE/sem2/BCME_BE8252.docx"));
                person.add(new data("CircuitTheory_EE8251.docx","Syllabus/EEE/sem2/CircuitTheory_EE8251.docx"));
                person.add(new data("EngineeringMathematics_II_MA8251.docx","Syllabus/EEE/sem2/EngineeringMathematics_II_MA8251.docx"));
                person.add(new data("EVS_GE8291.docx","Syllabus/EEE/sem2/EVS_GE8291.docx"));
                person.add(new data("PhysicsForElectronicsEngineering_PH8253.docx","Syllabus/EEE/sem2/PhysicsForElectronicsEngineering_PH8253.docx"));
                person.add(new data("TechnicalEnglish_HS8251.docx","Syllabus/EEE/sem2/TechnicalEnglish_HS8251.docx"));
                syll();
                break;
            case 9:
               // te.setText("(Sem 2)Question Paper for EEE Downloading...");
                person.add(new data("BCME_2018.pdf","QuestionPaper/sem2/EEE/BCME_2018.pdf"));
                person.add(new data("CircuitTheory_2018.pdf","QuestionPaper/sem2/EEE/CircuitTheory_2018.pdf"));
                person.add(new data("EngineeringMathematics_2018.pdf","QuestionPaper/sem2/EEE/EngineeringMathematics_2018.pdf"));
                person.add(new data("EVS_2018.pdf","QuestionPaper/sem2/EEE/EVS_2018.pdf"));
                person.add(new data("Physics_2018.pdf","QuestionPaper/sem2/EEE/Physics_2018.pdf"));
                person.add(new data("TechnicalEnglish_2018.pdf","QuestionPaper/sem2/EEE/TechnicalEnglish_2018.pdf"));
                syll();
                break;

            case 22:
                //te.setText("(Sem 2)Syllabus for Civil Downloading...");
                person.add(new data("BEEE_BE8251.docx","Syllabus/CIV/sem2/BEEE_BE8251.docx"));
                person.add(new data("EngineeringMathematics_II_MA8251.docx","Syllabus/CIV/sem2/EngineeringMathematics_II_MA8251.docx"));
                person.add(new data("EngineeringMechanics_GE8292.docx","Syllabus/CIV/sem2/EngineeringMechanics_GE8292.docx"));
                person.add(new data("EVS_GE8291.docx","Syllabus/CIV/sem2/EVS_GE8291.docx"));
                person.add(new data("PhysicsForCivil_PH8201.docx","Syllabus/CIV/sem2/PhysicsForCivil_PH8201.docx"));
                person.add(new data("TechnicalEnglish_HS8251.docx","Syllabus/CIV/sem2/TechnicalEnglish_HS8251.docx"));
                syll();
                break;

            case 120:
                //te.setText("(Sem 2)Question Paper for Civil Downloading...");
                person.add(new data("BCME_2018.pdf","QuestionPaper/sem2/CIV/BCME_2018.pdf"));
                person.add(new data("EM_2018.pdf","QuestionPaper/sem2/CIV/EM_2018.pdf"));
                person.add(new data("EngineeringMathematics_2018.pdf","QuestionPaper/sem2/CIV/EngineeringMathematics_2018.pdf"));
                person.add(new data("EVS_2018.pdf","QuestionPaper/sem2/CIV/EVS_2018.pdf"));
                person.add(new data("Physics_2018.pdf","QuestionPaper/sem2/CIV/Physics_2018.pdf"));
                person.add(new data("TechnicalEnglish_2018.pdf","QuestionPaper/sem2/CIV/TechnicalEnglish_2018.pdf"));
                syll();
                break;

            case 26:
                //te.setText("(Sem 2)Syllabus for Mech Downloading...");
                person.add(new data("BEEI_BE8253.docx","Syllabus/MECH/sem2/BEEI_BE8253.docx"));
                person.add(new data("EngineeringMathematics_II_MA8251.docx","Syllabus/MECH/sem2/EngineeringMathematics_II_MA8251.docx"));
                person.add(new data("EngineeringMechanics_GE8292.docx","Syllabus/MECH/sem2/EngineeringMechanics_GE8292.docx"));
                person.add(new data("EVS_GE8291.docx","Syllabus/MECH/sem2/EVS_GE8291.docx"));
                person.add(new data("MaterialScience_PH8251.docx","Syllabus/MECH/sem2/MaterialScience_PH8251.docx"));
                person.add(new data("TechnicalEnglish_HS8251.docx","Syllabus/MECH/sem2/TechnicalEnglish_HS8251.docx"));
                syll();

            case 160:
                //te.setText("(Sem 2)Question Paper for Mech Downloading...");
                person.add(new data("EM_2018.pdf","QuestionPaper/sem2/MEC/EM_2018.pdf"));
                person.add(new data("EngineeringMathematics_2018.pdf","QuestionPaper/sem2/MEC/EngineeringMathematics_2018.pdf"));
                person.add(new data("EVS_2018.pdf","QuestionPaper/sem2/MEC/EVS_2018.pdf"));
                person.add(new data("MaterialsScience_2018.pdf","QuestionPaper/sem2/MEC/MaterialsScience_2018.pdf"));
                person.add(new data("TechnicalEnglish_2018.pdf","QuestionPaper/sem2/MEC/TechnicalEnglish_2018.pdf"));
                syll();
                break;

                //*********************************************
                //Sem 3


            case 14:
                //te.setText("(Sem 3)Syllabus for CSE Downloading...");
                person.add(new data("CommunicationEngineering_EC8395.docx","Syllabus/CSE/sem3/CommunicationEngineering_EC8395.docx"));
                person.add(new data("DataStructures_CS8391.docx","Syllabus/CSE/sem3/DataStructures_CS8391.docx"));
                person.add(new data("DiscreteMathematics_MA8351.docx","Syllabus/CSE/sem3/DiscreteMathematics_MA8351.docx"));
                person.add(new data("DPSD_CS8351.docx","Syllabus/CSE/sem3/DPSD_CS8351.docx"));
                person.add(new data("OOP_CS8392.docx","Syllabus/CSE/sem3/OOP_CS8392.docx"));
                syll();


                break;
            case 04:
                //te.setText("(Sem 3)Question Paper for CSE Downloading...");

                break;

            case 17:
                //te.setText("(Sem 3)Syllabus for ECE Downloading...");
                person.add(new data("ControlSystemsEngineering_EC8391.docx","Syllabus/ECE/sem3/ControlSystemsEngineering_EC8391.docx"));
                person.add(new data("DigitalElectronics_EC8392.docx","Syllabus/ECE/sem3/DigitalElectronics_EC8392.docx"));
                person.add(new data("Electronics_Circuits_EC8351.docx","Syllabus/ECE/sem3/Electronics_Circuits_EC8351.docx"));
                person.add(new data("FundamentalsOfDataStructuresInC_EC8393.docx","Syllabus/ECE/sem3/FundamentalsOfDataStructuresInC_EC8393.docx"));
                person.add(new data("LinearAlgebra_MA8352.docx","Syllabus/ECE/sem3/LinearAlgebra_MA8352.docx"));
                person.add(new data("SignalsAndSystems_EC8352.docx","Syllabus/ECE/sem3/SignalsAndSystems_EC8352.docx"));
                syll();


                break;
            case 7:
                //te.setText("(Sem 3)Question Paper for ECE Downloading...");

                break;

            case 20:
                //te.setText("(Sem 3)Syllabus for EEE Downloading...");
                person.add(new data("DigitalLogicalCircuits_EE8351.docx","Syllabus/EEE/sem3/DigitalLogicalCircuits_EE8351.docx"));
                person.add(new data("ElectricMachines_EE8301.docx","Syllabus/EEE/sem3/ElectricMachines_EE8301.docx"));
                person.add(new data("ElectroMagneticTheory_EE8391.docx","Syllabus/EEE/sem3/ElectroMagneticTheory_EE8391.docx"));
                person.add(new data("ElectronDevicesAndCircuits_EC8353.docx","Syllabus/EEE/sem3/ElectronDevicesAndCircuits_EC8353.docx"));
                person.add(new data("PowerPlantEngineering_ME8792.docx","Syllabus/EEE/sem3/PowerPlantEngineering_ME8792.docx"));
                person.add(new data("TransformsAndPartialDifferentialEquations_MA8353.docx","Syllabus/EEE/sem3/TransformsAndPartialDifferentialEquations_MA8353.docx"));
                syll();
                break;
            case 10:
                //te.setText("(Sem 3)Question Paper for EEE Downloading...");

                break;

            case 23:
                //te.setText("(Sem 3)Syllabus for Civil Downloading...");
                person.add(new data("ConstructionMaterials_CE8391.docx","Syllabus/CIV/sem3/ConstructionMaterials_CE8391.docx"));
                person.add(new data("EngineeringGeology_CE8392.docx","Syllabus/CIV/sem3/EngineeringGeology_CE8392.docx"));
                person.add(new data("FluidMechanics_CE8302.docx","Syllabus/CIV/sem3/FluidMechanics_CE8302.docx"));
                person.add(new data("StrengthOfMaterials_CS8301.docx","Syllabus/CIV/sem3/StrengthOfMaterials_CS8301.docx"));
                person.add(new data("Surveying_CE8351.docx","Syllabus/CIV/sem3/Surveying_CE8351.docx"));
                person.add(new data("TransformsAndPartialDifferentialEquations_MA8353.docx","Syllabus/CIV/sem3/TransformsAndPartialDifferentialEquations_MA8353.docx"));
                syll();
                break;

            case 130:
                //te.setText("(Sem 3)Question Paper for Civil Downloading...");

                break;

            case 27:
                //te.setText("(Sem 3)Syllabus for Mech Downloading...");
                person.add(new data("ElectricalDrivesAndControls_EE8353.docx","Syllabus/MECH/sem3/ElectricalDrivesAndControls_EE8353.docx"));
                person.add(new data("EngineeringThermodynamics_ME8391.docx","Syllabus/MECH/sem3/EngineeringThermodynamics_ME8391.docx"));
                person.add(new data("FluidMechanicsAndMachinery_CE8394.docx","Syllabus/MECH/sem3/FluidMechanicsAndMachinery_CE8394.docx"));
                person.add(new data("ManufacturingTechnology_ME8351.docx","Syllabus/MECH/sem3/ManufacturingTechnology_ME8351.docx"));
                person.add(new data("TransformsAndPartialDifferentialEquations_MA8353.docx","Syllabus/MECH/sem3/TransformsAndPartialDifferentialEquations_MA8353.docx"));
                syll();
                break;

            case 170:
                //te.setText("(Sem 3)Question Paper for Mech Downloading...");

                break;

            //*********************************************
            //Sem 4
            case 990:
                //te.setText("(Sem 4) Syllabus for CSE");
                person.add(new data("ComputerArchitecture_CS8491.docx","Syllabus/CSE/sem4/ComputerArchitecture_CS8491.docx"));
                person.add(new data("DBMS_CS8492.docx","Syllabus/CSE/sem4/DBMS_CS8492.docx"));
                person.add(new data("DesignAndAnalysisOfAlgorithms_CS8451.docx","Syllabus/CSE/sem4/DesignAndAnalysisOfAlgorithms_CS8451.docx"));
                person.add(new data("OperatingSystems_CS8493.docx","Syllabus/CSE/sem4/OperatingSystems_CS8493.docx"));
                person.add(new data("PQT_MA8402.docx","Syllabus/CSE/sem4/PQT_MA8402.docx"));
                person.add(new data("SoftwareEngineering_CS8494.docx","Syllabus/CSE/sem4/SoftwareEngineering_CS8494.docx"));
                syll();
                break;
            case 991:
                //te.setText("(Sem 4) Syll for ECE");
                person.add(new data("CommunicationTheory_EC8491.docx","Syllabus/ECE/sem4/CommunicationTheory_EC8491.docx"));
                person.add(new data("ElectroMagneticFields_EC8451.docx","Syllabus/ECE/sem4/ElectroMagneticFields_EC8451.docx"));
                person.add(new data("ElectronicCircuits_EC8452.docx","Syllabus/ECE/sem4/ElectronicCircuits_EC8452.docx"));
                person.add(new data("EVS_GE8291.docx","Syllabus/ECE/sem4/EVS_GE8291.docx"));
                person.add(new data("LinearIntegratedCiruits_EC8453.docx","Syllabus/ECE/sem4/LinearIntegratedCiruits_EC8453.docx"));
                person.add(new data("ProbabilityAndRandomProcesses_MA8451.docx","Syllabus/ECE/sem4/ProbabilityAndRandomProcesses_MA8451.docx"));
                syll();
                break;
            case 992:
               // te.setText("(Sem 4) Syll for EEE");
                person.add(new data("ControlSystems_IC8451.docx","Syllabus/EEE/sem4/ControlSystems_IC8451.docx"));
                person.add(new data("ElectricalMachines_EE8401.docx","Syllabus/EEE/sem4/ElectricalMachines_EE8401.docx"));
                person.add(new data("LinearIntegratedCircuitsAndApplications_EE8451.docx","Syllabus/EEE/sem4/LinearIntegratedCircuitsAndApplications_EE8451.docx"));
                person.add(new data("MeasurementsAndInstrumentation_EE8403.docx","Syllabus/EEE/sem4/MeasurementsAndInstrumentation_EE8403.docx"));
                person.add(new data("NumericalMethods_MA8491.docx","Syllabus/EEE/sem4/NumericalMethods_MA8491.docx"));
                person.add(new data("TransmissionAndDistribution_EE8402.docx","Syllabus/EEE/sem4/TransmissionAndDistribution_EE8402.docx"));
                syll();
                break;
            case 993:
                //te.setText("(Sem 4) Syll for Civil");
                person.add(new data("AppliedHydraulicEngineering_CE8403.docx","Syllabus/CIV/sem4/AppliedHydraulicEngineering_CE8403.docx"));
                person.add(new data("ConcreteTechnology_CE8404.docx","Syllabus/CIV/sem4/ConcreteTechnology_CE8404.docx"));
                person.add(new data("ConstructionTechniquesAndPractices_CE8401.docx","Syllabus/CIV/sem4/ConstructionTechniquesAndPractices_CE8401.docx"));
                person.add(new data("NumericalMethods_MA8491.docx","Syllabus/CIV/sem4/NumericalMethods_MA8491.docx"));
                person.add(new data("SoilMechanics_CE8491.docx","Syllabus/CIV/sem4/SoilMechanics_CE8491.docx"));
                person.add(new data("StrengthOfMaterials_CE8402.docx","Syllabus/CIV/sem4/StrengthOfMaterials_CE8402.docx"));
                syll();
                break;
            case 994:
                //te.setText("(Sem 4) Syll for Mech");
                person.add(new data("EngineeringMetallurgy_ME8491.docx","Syllabus/MECH/sem4/EngineeringMetallurgy_ME8491.docx"));
                person.add(new data("KinematicsAndMachinery_ME8492.docx","Syllabus/MECH/sem4/KinematicsAndMachinery_ME8492.docx"));
                person.add(new data("ManufacturingTechnology_ME8451.docx","Syllabus/MECH/sem4/ManufacturingTechnology_ME8451.docx"));
                person.add(new data("StatisticsAndNumericalMethods_MA8452.docx","Syllabus/MECH/sem4/StatisticsAndNumericalMethods_MA8452.docx"));
                person.add(new data("StrengthOfMaterials_CE8395.docx","Syllabus/MECH/sem4/StrengthOfMaterials_CE8395.docx"));
                person.add(new data("ThermalEngineering_ME8493.docx","Syllabus/MECH/sem4/ThermalEngineering_ME8493.docx"));
                syll();
                break;



        }

    }
    public void syll(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        final NetworkInfo ninfo = connectivityManager.getActiveNetworkInfo();
        listView = findViewById(R.id.listView);
        dataAdapter arrayAdapter = new dataAdapter(this,person);
        listView.setAdapter(arrayAdapter);
        if(ninfo!=null && ninfo.isConnected()) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    data persons = person.get(position);
                    download(persons.getLinkName(), "Downloads");
                    Toast.makeText(DataFetchActivity.this,"Downloading..\nYour downloaded file is in\nAndroid -> Data -> " +
                            "com.AUStoreHouse -> Syllabus",Toast.LENGTH_LONG).show();
                    }
            });
        }else{
            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_LONG).show();
        }

    }


    public void download(final String Name,final String folderName){
            storageReference = firebaseStorage.getInstance().getReference();
            ref = storageReference.child(Name);
            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    String url = uri.toString();
                    downloadFile(DataFetchActivity.this, Name, folderName, url);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
    }

    public void downloadFile(Context context, String fileName, String destinationDirectory, String url) {

        DownloadManager downloadmanager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName);

        downloadmanager.enqueue(request);

    }

    public void displayInterstitial(){
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
    }





}
