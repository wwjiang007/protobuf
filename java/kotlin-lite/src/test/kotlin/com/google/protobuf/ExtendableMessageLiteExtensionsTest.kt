package com.google.protobuf.kotlin

import com.google.common.truth.Truth.assertThat
import example_extensible_message.ExampleExtensibleMessage
import example_extensible_message.ExampleExtensibleMessageOuterClass as TestProto
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ExtendableMessageLiteExtensionsTest {
  @Test
  fun setOnBuilder() {
    val builder = ExampleExtensibleMessage.newBuilder()
    builder[TestProto.int32Extension] = 5
    assertThat(builder.build().getExtension(TestProto.int32Extension)).isEqualTo(5)
  }

  @Test
  fun getOnBuilder() {
    val builder = ExampleExtensibleMessage.newBuilder()
      .setExtension(TestProto.int32Extension, 6)
    assertThat(builder[TestProto.int32Extension]).isEqualTo(6)
  }

  @Test
  fun getOnMessage() {
    val message = ExampleExtensibleMessage.newBuilder()
      .setExtension(TestProto.int32Extension, 6)
      .build()
    assertThat(message[TestProto.int32Extension]).isEqualTo(6)
  }

  @Test
  fun containsPositiveOnMessage() {
    val message = ExampleExtensibleMessage.newBuilder()
      .setExtension(TestProto.int32Extension, 6)
      .build()
    assertThat(TestProto.int32Extension in message).isTrue()
  }

  @Test
  fun containsPositiveOnBuilder() {
    val builder = ExampleExtensibleMessage.newBuilder()
      .setExtension(TestProto.int32Extension, 6)
    assertThat(TestProto.int32Extension in builder).isTrue()
  }

  @Test
  fun containsNegativeOnMessage() {
    val message = ExampleExtensibleMessage.newBuilder().build()
    assertThat(TestProto.int32Extension in message).isFalse()
  }

  @Test
  fun containsNegativeOnBuilder() {
    val builder = ExampleExtensibleMessage.newBuilder()
    assertThat(TestProto.int32Extension in builder).isFalse()
  }
}
