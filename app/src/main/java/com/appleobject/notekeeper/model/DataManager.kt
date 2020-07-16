package com.appleobject.notekeeper.model

import com.appleobject.notekeeper.ANDROID_ASYNC
import com.appleobject.notekeeper.ANDROID_INTENTS
import com.appleobject.notekeeper.JAVA_CORE
import com.appleobject.notekeeper.JAVA_LANG

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses(){
        var course = CourseInfo("android_intents", "Android Programming using Intents")
        courses.set(course.courseId, course)

        course = CourseInfo(courseId = "android_async", title = "Android Async Programming and Service")
        courses.set(course.courseId, course)

        course = CourseInfo(title = "Java Fundamentals: The Java Language", courseId = "java_lang")
        courses.set(course.courseId, course)

        course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
        courses.set(course.courseId, course)
    }

    private fun initializeNotes(){
        var note = NoteInfo(CourseInfo (courseId = "android_intents", title = ANDROID_INTENTS),
            title = "Dynamic Intent Resolution", text = "Wow, Intents allow components to be resolved at runtime"
        )
        notes.add(note)

        note = NoteInfo(CourseInfo("android_intents", ANDROID_INTENTS),
            title = "Delegating Intents",
            text = "PendingIntents are powerful, they delegate more than just a component invocation"
        )
        notes.add(note)

        note = NoteInfo(CourseInfo("android_async", ANDROID_ASYNC),
            title = "Service default thread",
            text = "Did you know that by default an android service will tie up the UI thread?"
        )
        notes.add(note)

        note = NoteInfo(CourseInfo("android_async", ANDROID_ASYNC),
            title = "Long running operations",
            text = "Foreground service can be tied to a notification icon"
        )
        notes.add(note)

        note = NoteInfo(CourseInfo("java_lang", JAVA_LANG),
            title = "Parameters",
            text = "Leverage variable-length parameter lists"
        )
        notes.add(note)

        note = NoteInfo(CourseInfo("java_lang", JAVA_LANG),
            title = "Anonymous classes",
            text = "Anonymous classes simplify implementing one-use type"
        )
        notes.add(note)

        note = NoteInfo(CourseInfo("java_core", JAVA_CORE),
            title = "Compiler options",
            text = "The -jar option isn't compatible with the -cp option"
        )
        notes.add(note)


    }
}