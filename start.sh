#!/bin/bash

# Create/Update the Database
cd backend
./gradlew liquibaseUpdate
cd ..

echo "Starting backend..."
cd backend
./gradlew bootRun &
BACKEND_PID=$!
cd ..

# Start the frontend
echo "Starting frontend..."
cd lottery-ui
npm start &
FRONTEND_PID=$!
cd ..

# Save the PIDs to a file
echo $BACKEND_PID > backend_pid.txt
echo $FRONTEND_PID > frontend_pid.txt

echo "Backend and frontend started successfully."
