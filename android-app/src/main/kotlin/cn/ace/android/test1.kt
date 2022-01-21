//package cn.ace.android
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.gestures.detectTapGestures
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.LazyListState
//import androidx.compose.foundation.lazy.rememberLazyListState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Button
//import androidx.compose.material.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.key.*
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun testComposable1() {
//  var count = remember {
//    mutableStateOf(10)
//  }
//  lateinit var state: LazyListState
//  Column(
//    Modifier
//      .padding(50.dp)
//      .background(Color.LightGray)
//      .padding(50.dp)
//      .pointerInput(1) {
//        val ps = this
//        ps.detectTapGestures()
//      }
//      .onKeyEvent { keyEvent: KeyEvent ->
//        val nativeKeyEvent: NativeKeyEvent = keyEvent.nativeKeyEvent
//        val key: Key = keyEvent.key
//        when (keyEvent.type) {
////          keyEvent.
//        }
//        true
//      }
//  ) {
//    Row {
//      Button(onClick = { count.value = 5 }) {
//        Text("按钮1")
//      }
////      Spacer(Modifier.size(100.dp))
//      Button(onClick = { count.value = 7 }) {
//        Text("按钮2")
//      }
//    }
//
//    LazyColumn(
//      Modifier
//        .background(Color.Magenta)
//        .padding(10.dp),
//      state = rememberLazyListState().also { state = it }
//    ) {
//      val maxDex = count.value - 1
//      items(maxDex) { dex ->
//        var modifier: Modifier = Modifier
//        if (dex != maxDex) {
//          modifier = modifier.padding(0.dp, 0.dp, 0.dp, 100.dp)
//        }
//        modifier = modifier
//          .size(200.dp, 200.dp)
//          .clip(RoundedCornerShape(percent = 50))
//          .background(Color.Red)
//
//        Text(
//          dex.toString(),
//          modifier,
//          textAlign = TextAlign.Center
//        )
//      }
//    }
//  }
//}
