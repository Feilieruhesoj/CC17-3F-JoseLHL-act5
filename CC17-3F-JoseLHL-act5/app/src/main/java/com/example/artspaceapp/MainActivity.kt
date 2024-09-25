package com.example.artspaceapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var artworkImageView: ImageView
    private lateinit var artworkTitleTextView: TextView
    private lateinit var artworkAuthorTextView: TextView
    private lateinit var artworkDescriptionTextView: TextView
    private lateinit var previousButton: MaterialButton
    private lateinit var nextButton: MaterialButton

    private val artworks = listOf(
        Artwork(
            R.drawable.starry_night,
            "Starry Night",
            "Vincent van Gogh",
            "The Starry Night is an oil-on-canvas painting by the Dutch Post-Impressionist painter Vincent van Gogh, painted in June 1889. It depicts the view from the east-facing window of his asylum room at Saint-Rémy-de-Provence, just before sunrise, with the addition of an imaginary village."
        ),
        Artwork(
            R.drawable.girl_with_a_pearl_earring,
            "Girl with a pearl earring",
            "Johannes Vermeer",
            "Girl with a Pearl Earring, oil painting on canvas (c. 1665) by Dutch artist Johannes Vermeer, one of his most well-known works. It depicts an imaginary young woman in exotic dress and a very large pearl earring."
        ),
        Artwork(
            R.drawable.liberty,
            "Liberty Leading the People",
            "Eugène Delacroix",
            "Liberty Leading the People, oil painting (1830) by French artist Eugène Delacroix commemorating the July Revolution in Paris that removed Charles X, the restored Bourbon king, from the throne. The heroic scene of rebellion was initially received with mixed reviews, but it became one of Delacroix’s most popular paintings, an emblem of the July Revolution and of justified revolt."
        ),
        Artwork(
            R.drawable.adam,
            "The Creation of Adam",
            "Michelangelo",
            "The Creation of Adam is probably the most famous fresco in the Sistine Chapel and one of the most famous in modern art.\n" +
                    "\n" +
                    "It was created by Michelangelo around 1511 and is located in the ceiling of the Sistine Chapel inside the Vatican Museums. It was one of the most complex and difficult paintings to make: it took sixteen days to complete. Michelangelo started with the figure of God and the Angels and later frescoed the figure of Adam."
        ),
        Artwork(
            R.drawable.napoleon,
            "Napoleon Crossing the Alps",
            "Jacques-Louis David",
            "The painting depicts Napoleon Bonaparte leading his army through the Alps on a mule, a journey Napoleon and his army of soldiers made in the spring of 1800 in an attempt to surprise the Austrian army in Italy. Several versions of this painting exist: in the Louvre- Lens and the Walker Art Gallery in Liverpool, England."
        )


    )

    private var currentArtworkIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        displayArtwork()
        updateButtonStates()

        previousButton.setOnClickListener { showPreviousArtwork() }
        nextButton.setOnClickListener { showNextArtwork() }
    }

    private fun initializeViews() {
        artworkImageView = findViewById(R.id.artworkImageView)
        artworkTitleTextView = findViewById(R.id.artworkTitleTextView)
        artworkAuthorTextView = findViewById(R.id.artworkAuthorTextView)
        artworkDescriptionTextView = findViewById(R.id.artworkDescriptionTextView)
        previousButton = findViewById(R.id.previousButton)
        nextButton = findViewById(R.id.nextButton)
    }

    private fun showPreviousArtwork() {
        if (currentArtworkIndex > 0) {
            currentArtworkIndex--
            displayArtwork()
            updateButtonStates()
        }
    }

    private fun showNextArtwork() {
        if (currentArtworkIndex < artworks.size - 1) {
            currentArtworkIndex++
            displayArtwork()
            updateButtonStates()
        }
    }

    private fun displayArtwork() {
        val currentArtwork = artworks[currentArtworkIndex]
        artworkImageView.setImageResource(currentArtwork.imageResourceId)
        artworkTitleTextView.text = currentArtwork.title
        artworkAuthorTextView.text = currentArtwork.author
        artworkDescriptionTextView.text = currentArtwork.description
    }

    private fun updateButtonStates() {
        previousButton.isEnabled = currentArtworkIndex > 0
        nextButton.isEnabled = currentArtworkIndex < artworks.size - 1

        previousButton.alpha = if (previousButton.isEnabled) 1.0f else 0.5f
        nextButton.alpha = if (nextButton.isEnabled) 1.0f else 0.5f
    }
}

data class Artwork(
    val imageResourceId: Int,
    val title: String,
    val author: String,
    val description: String
)
