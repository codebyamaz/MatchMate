package com.example.matchmate.activity;

import com.example.matchmate.R
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.matchmate.main.Main
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Signup : AppCompatActivity() {

    private lateinit var email: Button
    private lateinit var phoneNum: Button
    private lateinit var progressBar: ProgressBar


    companion object {
        private const val RC_SIGN_IN = 9001
    }

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signup)

        email = findViewById(R.id.btn_continue_with_google)
        phoneNum = findViewById(R.id.button3)

        // Initialize FirebaseAuth
        auth = FirebaseAuth.getInstance()

        phoneNum.setOnClickListener {
            val intent = Intent(applicationContext, PhoneNum::class.java)
            startActivity(intent)
        }

        email.setOnClickListener {

            signIn()
        }
    }

    private fun signIn() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(this, gso)
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                Toast.makeText(this, "Google sign in failed: ${e.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    Toast.makeText(this, "Signed in as ${user?.displayName}", Toast.LENGTH_SHORT)
                        .show()

                    // Check if user's UID exists in the Realtime Database
                    val uid = user?.uid
                    if (uid != null) {
                        val userRef = FirebaseDatabase.getInstance().getReference("User").child(uid)
                        userRef.addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                if (snapshot.exists()) {
                                    // User already exists in the database
                                    startActivity(Intent(this@Signup, Main::class.java))
                                } else {
                                    // User doesn't exist in the database, add user information
                                    val name = user.displayName
                                    val email= user.email
                                    val lastName = ""
                                    val dateOfBirth = ""

                                    // Set user information
                                    userRef.child("name").setValue(name)
                                    userRef.child("email").setValue(email)
                                    userRef.child("lastName").setValue(lastName)
                                    userRef.child("dateOfBirth").setValue(dateOfBirth)

                                    // Redirect to I am activity
                                    startActivity(Intent(this@Signup, Iam::class.java))
                                }
                                finish()
                            }

                            override fun onCancelled(error: DatabaseError) {
                                // Handle onCancelled if needed
                            }
                        })
                    } else {
                        // Handle the case where UID is null
                        Toast.makeText(this, "Failed to retrieve UID", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                }
            }
    }


}
