const express = require("express");
const router = express.Router();
const fs = require("fs");
const path = require("path");
const nanoid = require("nanoid");

const createFileController = router.get("/", (_, res, next) => {
  const filePath = process.env.FILE_PATH || "files"
  const id = nanoid.nanoid();
  const content = `This is a log file written with id: ${id}`;
  try {
    console.time(`fileSave ${id}`);
    fs.writeFile(path.join(filePath, `log-rotate-${id}.txt`), content, { flag: "w+" }, (err) => {
      if (err) {
        console.log(err);
        return res.status(500).json({ error: err });
      }
      console.timeEnd(`fileSave ${id}`);
      return res.json({ message: `Creating log file with id: ${id}` });
    });
  } catch (error) {
    console.log(error);
    next(error)
  }
});

module.exports = createFileController;
