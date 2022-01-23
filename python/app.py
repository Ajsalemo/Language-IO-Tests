import os
import uuid

from dotenv import load_dotenv
from flask import Flask, jsonify

app = Flask(__name__)
load_dotenv()


@app.route("/")
def index():
    return "Language-IO-Tests-Python"


@app.route("/file/create")
def file_create():
    id = uuid.uuid4()
    d = os.getenv("FILE_PATH", "files")
    w = f"{d}/log-rotate-{id}.txt"
    try:
        f = open(w, "w")
        f.write(f"This is a log file written with id: {id}")
        f.close()
        return jsonify({"message": f"Creating log file with id: {id}"})
    except Exception as e:
        print(e)
        return jsonify({"error": str(e)}), 500


@app.route("/file/append")
def file_append():
    id = uuid.uuid4()
    d = os.getenv("FILE_PATH", "files")
    a = f"{d}/log-append.txt"
    try:
        f = open(a, "a")
        f.write(f"This logfile is appended with id: {id} \n")
        f.close()
        return jsonify({"message": f"Appending to log-append.txt"})
    except Exception as e:
        print(e)
        return jsonify({"error": str(e)}), 500
