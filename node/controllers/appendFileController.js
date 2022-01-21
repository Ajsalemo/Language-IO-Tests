const express = require("express");
const router = express.Router();
const fs = require("fs");
const path = require("path");
const nanoid = require("nanoid");

const appendFileController = router.get("/", (_, res, next) => {
  const id = nanoid.nanoid();
  const content = `This logfile is appended with id: ${id} \n`;
  try {
    fs.writeFile(path.join("files", `log-append.txt`), content, { flag: "a" }, (err) => {
      if (err) {
        console.log(err);
        return res.status(500).json({ error: err });
      }
      return res.json({ message: `Appending to log-append.txt` });
    });
  } catch (error) {
    console.log(error);
    next(error)
  }
});

module.exports = appendFileController;
