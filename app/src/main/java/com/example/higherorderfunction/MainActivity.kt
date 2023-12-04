package com.example.higherorderfunction

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.higherorderfunction.coroutine.StartCoroutines
import com.example.higherorderfunction.coroutine.SuspendUse
import com.example.higherorderfunction.coroutine.SuspendUse.Companion.getFeedList
import com.example.higherorderfunction.coroutine.SuspendUse.Companion.getFriendList
import com.example.higherorderfunction.coroutine.SuspendUse.Companion.getUserInfo
import com.example.higherorderfunction.ui.theme.HigherOrderFunctionTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HigherOrderFunctionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

//        val startCoroutines = StartCoroutines()
//        val suspendUse = SuspendUse()

//       startCoroutines.runBlocking()
//        startCoroutines.runCoroutine()

//        lifecycleScope.launch(Dispatchers.Main) {
//            Log.i("minfo", startCoroutines.getResult())
//        }

//        lifecycleScope.launch {
//            val user = getUserInfo()
//            val friendList = getFriendList(user)
//            val feedList = getFeedList(friendList)
//            Log.i("minfo", feedList)
//        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HigherOrderFunctionTheme {
        Greeting("Android")
    }
}