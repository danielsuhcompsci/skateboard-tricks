# Skateboard Trick Classifier

This app lets you classify skateboard tricks (currently ollie and kickflip) in a easy-to-use web application, leveraging the power of transformers (finetuned VideoMAE).

## Front End

The front end is build with Vue.js and uses Cypress for testing. It allows a user to upload a video and receive predictions. 

## Back End

The back end is a Java Spring Boot web server that sends the uploaded video to the inference endpoint and returns the prediction. 

## Running in a Test Environment

```
pnpm install
```

```
pnpm run dev
```

### Starting the Server

**MacOS/Linux**
```
./gradlew bootRun
```

**Windows**
```
.\gradlew.bat bootRun
```
