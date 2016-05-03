var express = require('express');
var cors = require('cors');
var bodyParser = require('body-parser');
var sql = require('mssql');
var humps = require('humps');
var app = express();

app.use(cors());

app.use(bodyParser.json()); 

var config = {
    driver: 'msnodesqlv8',
    server: 'localhost',
    database: 'SOSS',
    options: {
        trustedConnection: true,
        useUTC: true
    }
}

app.get('/api/tasks', function (req, res) {
  sql.connect(config).then(function() {
    new sql.Request().query('select * from tasks').then(function(recordset) {
        res.send(humps.camelizeKeys(recordset));
    }).catch(function(err) {
        console.log(err);
    });
  });
});

app.get('/api/tasks/:id', function (req, res) {
  sql.connect(config).then(function() {
    var ps = new sql.PreparedStatement();
    ps.input('id', sql.Int);
    ps.prepare('select * from tasks where taskId = @id', function(err) {
        ps.execute({id: req.params.id}, function(err, recordset) {
            res.send(humps.camelizeKeys(recordset));
            ps.unprepare(function(err) {
              if(err) {
                console.log(err);
              }
            });
        });
        
    });
  });
});

app.post('/api/tasks', function (req, res) {
  sql.connect(config).then(function() {
    var ps = new sql.PreparedStatement();
    ps.input('name', sql.NVarChar(sql.MAX));
    ps.input('priority', sql.Int);
    ps.input('description', sql.NVarChar(sql.MAX));
    ps.input('id', sql.Int);
    ps.prepare('insert into tasks (name, priority, description) VALUES (@name, @priority, @description)', function(err) {
        ps.execute(req.body, function(err, recordset) {
            res.send();
            ps.unprepare(function(err) {
              if(err) {
                console.log(err);
              }
            });
        });
        
    });
  });
});

app.put('/api/tasks/:id', function (req, res) {
  sql.connect(config).then(function() {
    var ps = new sql.PreparedStatement();
    ps.input('name', sql.NVarChar(sql.MAX));
    ps.input('priority', sql.Int);
    ps.input('description', sql.NVarChar(sql.MAX));
    ps.input('id', sql.Int);
    ps.prepare('update tasks set name = @name, priority = @priority, description = @description where taskId = @id', function(err) {
        req.body.id = req.params.id;
        ps.execute(req.body, function(err, recordset) {
            res.send();
            ps.unprepare(function(err) {
              if(err) {
                console.log(err);
              }
            });
        });
        
    });
  });
});

app.delete('/api/tasks/:id', function (req, res) {
  sql.connect(config).then(function() {
    var ps = new sql.PreparedStatement();
    ps.input('id', sql.Int);
    ps.prepare('delete from tasks where taskId = @id', function(err) {
        ps.execute({id: req.params.id}, function(err, recordset) {
            res.send();
            ps.unprepare(function(err) {
              if(err) {
                console.log(err);
              }
            });
        });
        
    });
  });
});

app.listen(3000, function () {
  console.log('REST API listening on port 3000!');
});