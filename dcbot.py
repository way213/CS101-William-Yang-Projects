import discord
import json
import requests
import random
import os
from dotenv import load_dotenv



intents = discord.Intents().all()
client = discord.Client(intents=intents);

@client.event
async def on_ready():
    print('We have logged in as {0.user}'.format(client))

def get_quote():                                                   #get a quote from whatever website
    response = requests.get("https://zenquotes.io/api/random")
    json_data = json.loads(response.text)
    quote = json_data[0]['q'] + " -" + json_data[0]['a']           #from the zen quotes API
    return quote

sad_words = ["sad", "depressed", "unhappy", "angry", "miserable", "depressing"]
starter_encouragements = ["Cheer up!", "Hang in there!", "You are a great person / bot!"]


@client.event
async def on_message(message):
    channel = client.get_channel(1038568738708017155)
    msg = message.content                                        #content of message
    if message.author == client.user:
        return
    if message.content.startswith("hello"):                    #if message starts with "hello"
        quote= get_quote()
        await message.channel.send(quote)
    if any(word in msg for word in sad_words):                  #if there are words in sad_words that are in the message
        await message.channel.send(random.choice(starter_encouragements))
    if message.content.startswith("end_bot"):                       #ending session
        await message.channel.send("ending session")
        quit()
    


load_dotenv()                                                     #environment variables

KEY = os.getenv("TOKEN")                                           #get token
client.run(KEY)                                                   #run the bot