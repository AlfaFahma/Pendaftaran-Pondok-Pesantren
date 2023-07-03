package com.example.pendaftaranpondokpesantren.ui

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.ksatria.pendaftaranpondokpesantren.model.Registration
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class SecondFragment(
    public val registration: Registration?
) : NavArgs {
    @Suppress("CAST_NEVER_SUCCEEDS")
    public fun toBundle(): Bundle {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Registration::class.java)) {
            result.putParcelable("registration", this.registration as Parcelable?)
        } else if (Serializable::class.java.isAssignableFrom(Registration::class.java)) {
            result.putSerializable("registration", this.registration as Serializable?)
        } else {
            throw UnsupportedOperationException(Registration::class.java.name +
                    " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
    }

    @Suppress("CAST_NEVER_SUCCEEDS")
    public fun toSavedStateHandle(): SavedStateHandle {
        val result = SavedStateHandle()
        if (Parcelable::class.java.isAssignableFrom(Registration::class.java)) {
            result.set("registration", this.registration as Parcelable?)
        } else if (Serializable::class.java.isAssignableFrom(Registration::class.java)) {
            result.set("registration", this.registration as Serializable?)
        } else {
            throw UnsupportedOperationException(Registration::class.java.name +
                    " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
    }

    public companion object {
        @JvmStatic
        @Suppress("DEPRECATION")
        public fun fromBundle(bundle: Bundle): SecondFragment {
            bundle.setClassLoader(SecondFragment::class.java.classLoader)
            val __registration : Registration?
            if (bundle.containsKey("registration")) {
                if (Parcelable::class.java.isAssignableFrom(Registration::class.java) ||
                    Serializable::class.java.isAssignableFrom(Registration::class.java)) {
                    __registration = bundle.get("registration") as Registration?
                } else {
                    throw UnsupportedOperationException(Registration::class.java.name +
                            " must implement Parcelable or Serializable or must be an Enum.")
                }
            } else {
                throw IllegalArgumentException("Required argument \"registration\" is missing and does not have an android:defaultValue")
            }
            return SecondFragment(__registration)
        }

        @JvmStatic
        public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): SecondFragment {
            val __registration : Registration?
            if (savedStateHandle.contains("registration")) {
                if (Parcelable::class.java.isAssignableFrom(Registration::class.java) ||
                    Serializable::class.java.isAssignableFrom(Registration::class.java)) {
                    __registration = savedStateHandle.get<Registration?>("registration")
                } else {
                    throw UnsupportedOperationException(Registration::class.java.name +
                            " must implement Parcelable or Serializable or must be an Enum.")
                }
            } else {
                throw IllegalArgumentException("Required argument \"registration\" is missing and does not have an android:defaultValue")
            }
            return SecondFragment(__registration)
        }
    }
}