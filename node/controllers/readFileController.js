const express = require("express");
const router = express.Router();
const fs = require("fs");
const path = require("path");
const nanoid = require("nanoid");

const readFileController = router.get("/", (_, res, next) => {
  const filePath = process.env.FILE_PATH || "files";
  try {
    fs.readFile(path.join(filePath, `log-append.txt`), "utf8", (err, data) => {
      if (err) {
        console.log(err);
        return res.status(500).json({ error: err });
      }
      return res.json({ message: data });
    });
  } catch (error) {
    console.log(error);
    next(error);
  }
});

module.exports = readFileController;
