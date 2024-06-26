This app is a simple React app with TS.

Did not put effort on the UI part itself, but rather tried to make some internal parts prettier.

There are two pages (views). One is for login and another is for generating the numbers.

One of the requirement was that is a user changes we should show only numbers for that user.
Hence, the generate numbers will only be accessible if a user is present in the state.

I split the code into some common parts (like store, css, api etc.). 
Again, maybe it's an overkill for this task, 
but in a real world scenario this would greatly help to improve the dev experience by 
separating the code by logical layers.

For the state I used redux

To run the app, simply ```npm start``` would do. The backend URL is moved into a variable
and by default pointing to localhost:8080