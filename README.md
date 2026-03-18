# AI-Powered Diabetes Prediction & Monitoring System
<img width="2470" height="1330" alt="image" src="https://github.com/user-attachments/assets/2e95ee27-0445-4c88-8541-9fb614f4dfcc" />

A distributed, real-time application for predicting and monitoring diabetes risk using machine learning and secure API-based architecture.

## 🧠 Features

- Real-time diabetes risk prediction using a pre-trained deep learning model.
- Multi-user role support (Doctor & Patient).
- Prediction history tracking and filtering.
- Role-based authentication and authorization.
- Containerized deployment using Docker Compose.
- Load balancing with NGINX.
- Scalable PostgreSQL database with PgBouncer.

---

This project is a distributed, containerized system for predicting and monitoring diabetes using a machine learning model and real-time APIs. It includes:
•	- Flask backend with ML inference
•	- PostgreSQL database with PgBouncer for pooling
•	- NGINX load balancer across multiple backend instances
•	- Docker Compose for orchestration

Folder Structure
----------------
.
├── app.py                 # Main Flask application
├── app_api.py                 # Main Flask application
├── docker-compose.yml     # Docker Compose config for full system
├── Dockerfile             # Container build for Flask API
├── nginx.conf             # Load balancing configuration for NGINX
├── requirements.txt       # Python dependencies
├── diabetes_model.h5      # Trained deep learning model
├── scaler.pkl             # Data standardization scaler
└── templates/             # Frontend HTML files 

How to Run Locally (Using Docker)
---------------------------------
Prerequisites:
•	- Docker desktop & Docker Compose installed (https://docs.docker.com/get-docker/)

Step 1: Download or Clone the Project
-------------------------------------
Open CMD
If on GitHub:
git clone https://github.com/your-username/diabetes-prediction-system.git
cd diabetes-prediction-system
cd local_docker
If on local directory:
Cd to application directory 
Example: 
Cd ...\local_docker\apps_Server

Step 2: Ensure Required Files Exist
-----------------------------------
Make sure these files are present in the root directory:
•	- app.py
•	- app_api.py                 
•	- Dockerfile
•	- docker-compose.yml
•	- nginx.conf
•	- diabetes_model.h5
•	- scaler.pkl
•	- requirements.txt
•	- templates/ 
-	index.html
-	login.html
-	register.html
-	history.html
-	prediction.html
-	patients.html
-	doctors.html

Step 3: Run the System
----------------------
docker-compose up –build
After complete run:
docker exec -it postgres-master psql -U admin -d diabetes_db
ALTER USER admin WITH PASSWORD 'password';
postgres -c password_encryption=md5
\q
This will:
•	- Build multiple Flask backends (backend1, backend2, backend3)
•	- Start PostgreSQL and PgBouncer
•	- Launch NGINX as load balancer
•	- Expose the app on: http://localhost:8080
•	- Expose the app api on: http://localhost:5051

Component Overview
------------------
Component     | Port  | Description
--------------|-------|-----------------------------
NGINX         | 8080  | Load-balanced entry point
Flask APPS     | 5001–5003 | Multiple backend instances
Flask API          5051   application rest api
PostgreSQL    | 5432  | Database server
PgBouncer     | 6432  | Connection pooling for Postgres

Usage
-----
•	- Open browser to http://localhost:8080
•	- Register or login as doctor
•	- Navigate to prediction form
•	- Input patient values → get real-time diabetes risk prediction
•	- Check prediction history and export results

Testing
-------
Tests are handled through Flask routes and manual inputs:
•	- Validate ML output via /Predict
•	- Check resilience by stopping a backend container:
docker stop backend2
•	- System continues functioning via NGINX failover

Security Notes
--------------
•	- Passwords are hashed using Flask-Bcrypt
•	- Session-managed routes with Flask-Login
•	- Backend secured behind NGINX reverse proxy
•	- Environment variables handle DB credentials

Cleaning Up
-----------
To stop and remove all containers:
docker-compose down -v

