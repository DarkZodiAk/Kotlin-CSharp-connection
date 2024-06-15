## Kotlin + C# Example
This is a Windows toast notification sender. Kotlin handles UI, and C# uses Windows API to send notifications. These parts are connected via sockets. 
<br>
This simple example was made to show, that if you want to make Windows application on Kotlin, but it should have some WindowsAPI related features (Which Kotlin & Java can't do), 
you may consider using C# FOR ONLY these features, then write the rest of logic in Kotlin and connect all parts via sockets.
