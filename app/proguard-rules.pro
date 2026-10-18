# Add project specific ProGuard rules here.

# ─── Preserve stack traces ────────────────────────────────────────────────────
-keepattributes SourceFile, LineNumberTable
-renamesourcefileattribute SourceFile

# ─── Room ─────────────────────────────────────────────────────────────────────
# Entity field names are used at runtime for column mapping when @ColumnInfo
# isn't explicitly specified on every field.
-keepclassmembers @androidx.room.Entity class * { *; }
-keepclassmembers @androidx.room.DatabaseView class * { *; }

# ─── Hilt / Dagger ────────────────────────────────────────────────────────────
# @HiltViewModel classes must be kept so Hilt's generated factories can find them.
-keepnames @dagger.hilt.android.lifecycle.HiltViewModel class *
# Injected fields and methods accessed reflectively by Dagger.
-keepclassmembers class * {
    @javax.inject.Inject <fields>;
    @javax.inject.Inject <init>(...);
}

# ─── WorkManager ──────────────────────────────────────────────────────────────
# WorkManager instantiates Workers by class name via WorkerFactory — they must
# survive shrinking and renaming.
-keep public class * extends androidx.work.Worker
-keep public class * extends androidx.work.CoroutineWorker
-keep public class * extends androidx.work.ListenableWorker {
    public <init>(android.content.Context, androidx.work.WorkerParameters);
}

# ─── Kotlin Coroutines ────────────────────────────────────────────────────────
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
-dontwarn kotlinx.coroutines.**

# ─── Kotlin Metadata (required for reflection-based libs) ─────────────────────
-keepattributes *Annotation*, InnerClasses, Signature, Exceptions

# ─── Domain Models ────────────────────────────────────────────────────────────
# Originally kept for Wear Data Layer sync, which has been removed. Nothing reflects on these
# classes now; drop this rule once a release build has been verified without it.
-keep class com.ataraxy.app.domain.model.** { *; }
