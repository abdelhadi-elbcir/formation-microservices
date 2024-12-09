#!/bin/bash

# Array of services
services=(
  "api-gateway"
  "discovery-service"
  "notification-service"
  "task-service"
)

# Path to the root directory where services are located
BASE_DIR="/home/elbcir/formation-microservices"

# Function to start a service
start_service() {
  local service_name=$1
  cd "$BASE_DIR/$service_name" || { echo "Directory $BASE_DIR/$service_name does not exist"; return; }
  
  # Start the service in a new terminal tab
  gnome-terminal --tab --title="$service_name" -- bash -c "mvn spring-boot:run; exec bash"
}

# Iterate over the services and start each
for service in "${services[@]}"; do
  start_service "$service"
done

echo "All services are starting..."

