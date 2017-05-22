from bottle import route, run, template, response
from scholar import json_res

@route('/scholar/gscholars')
def returnresp():
    return "Usage: http://everest.expertsystemlab.com/scholar/gscholars/quantum"

@route('/scholar/gscholars/<search>')
def returnarray(search):
    n_res = 10
    res = json_res(search.replace("%20"," "), n_res)
    response.content_type = 'application/json'
    return res

run(host='172.16.32.89', port=8084)
