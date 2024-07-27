package com.example.editkaro;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mukesh.image_processing.ImageProcessor;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Another_Activity extends AppCompatActivity {

    private ImageView originalIV;
    private Bitmap originalBitmap;
    private Bitmap filteredBitmap;
    ImageView oneIV, twoIV, threeIV, fourIV, fiveIV, sixIV, sevenIV, eightIV;
    Bitmap oneBitMap, twoBitMap, threeBitmap, fourBitMap, fiveBitMap, sixBitMap, sevenBitMap, eightBitMap;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private final Handler handler = new Handler(Looper.getMainLooper());
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        originalIV = findViewById(R.id.idIVOriginalImage);
        progressBar = findViewById(R.id.progressBar);

        String imageUriString = getIntent().getStringExtra("originalImageUri");
        Uri originalImageUri = Uri.parse(imageUriString);

        // Load original image
        try {
            originalBitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(originalImageUri));
            originalIV.setImageBitmap(originalBitmap);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to load image", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        //int scaledWidth = originalBitmap.getWidth() / 2;
        //int scaledHeight = originalBitmap.getHeight() / 2;

        // Initialize image views for filters
        oneIV = findViewById(R.id.idIVOne);
        twoIV = findViewById(R.id.idIVTwo);
        threeIV = findViewById(R.id.idIVThree);
        fourIV = findViewById(R.id.idIVFour);
        fiveIV = findViewById(R.id.idIVFive);
        sixIV = findViewById(R.id.idIVSix);
        sevenIV = findViewById(R.id.idIVSeven);
        eightIV = findViewById(R.id.idIVEight);


        // Show progress bar
        progressBar.setVisibility(View.VISIBLE);

        // Load and apply filters in the background
        executorService.submit(() -> {
            ImageProcessor processor = new ImageProcessor();
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, originalBitmap.getWidth() / 2, originalBitmap.getHeight() / 2, true);

            // Generate filtered bitmaps using scaledBitmap
            oneBitMap = processor.tintImage(scaledBitmap,90);
           // if (oneBitMap != null) {
             //   oneBitMap.recycle();
            twoBitMap = processor.applyGaussianBlur(scaledBitmap);
            threeBitmap = processor.createSepiaToningEffect(scaledBitmap, 1, 2, 1, 5);
            fourBitMap = processor.applySaturationFilter(scaledBitmap, 3);
            fiveBitMap = processor.applySnowEffect(scaledBitmap);
            sixBitMap = processor.doGreyScale(scaledBitmap);
            sevenBitMap = processor.engrave(scaledBitmap);
            eightBitMap = processor.createContrast(scaledBitmap, 1.5);


            // Update UI on the main thread
            handler.post(() -> {
                oneIV.setImageBitmap(oneBitMap);
                twoIV.setImageBitmap(twoBitMap);
                threeIV.setImageBitmap(threeBitmap);
                fourIV.setImageBitmap(fourBitMap);
                fiveIV.setImageBitmap(fiveBitMap);
                sixIV.setImageBitmap(sixBitMap);
                sevenIV.setImageBitmap(sevenBitMap);
                eightIV.setImageBitmap(eightBitMap);
//                nineIV.setImageBitmap(nineBitMap);
//                tenIV.setImageBitmap(tenBitMap);

                // Hide progress bar
                progressBar.setVisibility(View.GONE);

                initializeOnClickListeners();
            });
        });

        findViewById(R.id.start).setOnClickListener(v -> applyFiltersAndSave());
    }

    private void initializeOnClickListeners() {
        oneIV.setOnClickListener(v -> {
            originalIV.setImageBitmap(oneBitMap);
            filteredBitmap = oneBitMap;
        });

        twoIV.setOnClickListener(v -> {
            originalIV.setImageBitmap(twoBitMap);
            filteredBitmap = twoBitMap;
        });

        threeIV.setOnClickListener(v -> {
            originalIV.setImageBitmap(threeBitmap);
            filteredBitmap = threeBitmap;
        });

        fourIV.setOnClickListener(v -> {
            originalIV.setImageBitmap(fourBitMap);
            filteredBitmap = fourBitMap;
        });

        fiveIV.setOnClickListener(v -> {
            originalIV.setImageBitmap(fiveBitMap);
            filteredBitmap = fiveBitMap;
        });

        sixIV.setOnClickListener(v -> {
            originalIV.setImageBitmap(sixBitMap);
            filteredBitmap = sixBitMap;
        });

        sevenIV.setOnClickListener(v -> {
            originalIV.setImageBitmap(sevenBitMap);
            filteredBitmap = sevenBitMap;
        });

        eightIV.setOnClickListener(v -> {
            originalIV.setImageBitmap(eightBitMap);
            filteredBitmap = eightBitMap;
        });


    }

    private void applyFiltersAndSave() {
        if (filteredBitmap != null) {
            // Save the filtered image to the gallery
            String savedImageURL = MediaStore.Images.Media.insertImage(
                    getContentResolver(),
                    filteredBitmap,
                    "Filtered_Image",
                    "Image filtered and saved using Edit Karo"
            );

            if (savedImageURL != null) {
                Toast.makeText(this, "Image saved to gallery", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No filter applied", Toast.LENGTH_SHORT).show();
        }
    }
}




