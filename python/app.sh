# export FLASK_APP=python_backend
# flask run

export FLASK_APP=./python_backend
waitress-serve --host 0.0.0.0 --port 8080 python_backend:app
#flask run -p 8080 --host=0.0.0.0