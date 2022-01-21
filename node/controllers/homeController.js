const express = require("express");
const router = express.Router();

const homeController = router.get("/", (_, res, next) => {
  try {
    res.json({ message: "Language-IO-Tests-Node" });
  } catch (error) {
    console.log(error);
    next(error);
  }
});

module.exports = homeController;
