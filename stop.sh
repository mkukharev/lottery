#!/bin/bash

# Function to kill a process by PID file
kill_process() {
  if [ -f $1 ]; then
    PID=$(cat $1)
    if ps -p $PID > /dev/null; then
      kill $PID
      echo "Stopped process with PID $PID from $1"
    else
      echo "No process found with PID $PID in $1"
    fi
    rm $1
  else
    echo "PID file $1 not found"
  fi
}

# Stop the backend
kill_process backend_pid.txt

# Stop the frontend
kill_process frontend_pid.txt

echo "Backend and frontend stopped successfully."